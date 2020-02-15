package com.example.myorder.services;

import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.api.mappers.ProductMapper;
import com.example.myorder.api.mappers.RestaurantMapper;
import com.example.myorder.entities.Product;
import com.example.myorder.entities.Restaurant;
import com.example.myorder.exceptions.NotFoundException;
import com.example.myorder.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestaurantService restaurantService;

    public ProductResponseDto createProduct(CreateProductDto createProductDto) {

        Restaurant restaurant = restaurantService.findById(createProductDto.getRestaurantId());

        Product product = ProductMapper.toEntity(createProductDto)
                .setRestaurant(restaurant);

        return ProductMapper.toResponseDto(productRepository.save(product)).setRestaurant(restaurantService.getById(product.getRestaurant().getId()));
    }

    public ProductResponseDto getById(Integer id) {
        Optional<Product> optional = productRepository.findById(id);

        if(optional.isPresent()){
            Product product = optional.get();
            return new ProductResponseDto()
                    .setName(product.getName())
                    .setValue(product.getValue());
        }
        return null;
    }

    public Product findById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Produto não encntrado para o id " + id + "."));
    }

    public List<Product> listById(List<Integer> ids) {
        return productRepository.findAllById(ids);
    }

    public ProductResponseDto createProductResponseDto(Product product, Restaurant restaurant) {
        return new ProductResponseDto()
                .setName((product.getName()))
                .setValue((product.getValue()))
                .setRestaurant(RestaurantMapper.toResponseDto(restaurant));
    }

}
