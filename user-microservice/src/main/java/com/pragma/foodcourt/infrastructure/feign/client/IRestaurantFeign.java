package com.pragma.foodcourt.infrastructure.feign.client;

import com.pragma.foodcourt.infrastructure.feign.dto.restaurant.RestaurantRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.restaurant.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Feign client for microservice restaurant.
 */
@FeignClient(name = "restaurant", url = "localhost:8091/api/food-court/restaurant")
public interface IRestaurantFeign {

    //Get restaurants.
    @GetMapping("/")
    ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants();

    //Save restaurant.
    @PostMapping("/")
    ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto);


}
