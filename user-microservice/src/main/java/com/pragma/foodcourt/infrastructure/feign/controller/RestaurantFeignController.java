package com.pragma.foodcourt.infrastructure.feign.controller;

import com.pragma.foodcourt.infrastructure.feign.client.IRestaurantFeign;
import com.pragma.foodcourt.infrastructure.feign.dto.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/restaurant")
public class RestaurantFeignController {

    private final IRestaurantFeign restaurantFeign;

    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return restaurantFeign.getAllRestaurants();
    }

}
