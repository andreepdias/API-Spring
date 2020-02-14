package com.example.myorder.api.controllers;

import com.example.myorder.api.dtos.CreateProductDto;
import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.api.dtos.ProductResponseDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.services.ProductService;
import com.example.myorder.services.RestaurantService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(RestPath.BASE_PATH + "/product")
@Api(tags =  "Produtos")
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiResponses({
            @ApiResponse(code = 201, message = "Produto criado!", response = ProductResponseDto.class)
    })
    public ProductResponseDto create(@RequestBody @Valid CreateProductDto createProductDto) {
        return productService.createProduct(createProductDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public ProductResponseDto get(@RequestParam @Param("id") Integer id) {
        return productService.getById(id);
    }
}
