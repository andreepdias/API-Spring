package com.example.myorder.api.mappers;

import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.CreateUserDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.api.dtos.UserResponseDto;
import com.example.myorder.entities.Product;
import com.example.myorder.entities.User;
import org.modelmapper.ModelMapper;

public class ProductMapper {

    private static final ModelMapper modelMapper = new ModelMapper();

    public static Product toEntity(CreateProductDto createProductDto){
        return modelMapper.map(createProductDto, Product.class);
    }

    public static ProductResponseDto toResponseDto(Product product){
        return modelMapper.map(product, ProductResponseDto.class);
}

}
