package com.example.myorder.api.controllers;

import com.example.myorder.api.dtos.CreateRestaurantDto;
import com.example.myorder.api.dtos.RestaurantResponseDto;
import com.example.myorder.services.RestaurantService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController("RestaurantControllerV1")
@RequestMapping(RestPath.BASE_PATH + "/restaurant")
@Api(tags = "Restaurantes")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestBody @Valid CreateRestaurantDto createRestaurantDto) {
        restaurantService.createRestaurant(createRestaurantDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public RestaurantResponseDto get(@RequestParam @Param("id") Integer id) {
        return restaurantService.getById(id);
    }


}

