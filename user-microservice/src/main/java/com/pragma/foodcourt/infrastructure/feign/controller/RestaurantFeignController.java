package com.pragma.foodcourt.infrastructure.feign.controller;

import com.pragma.foodcourt.infrastructure.feign.client.IRestaurantFeign;
import com.pragma.foodcourt.infrastructure.feign.dto.restaurant.RestaurantRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.restaurant.RestaurantResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller feign restaurant.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/restaurant")
public class RestaurantFeignController {

    private final IRestaurantFeign restaurantFeign;

    /**
     * Gets the restaurants if the user is a CUSTOMER.
     */
    @Secured({"CUSTOMER"})
    @GetMapping("/")
    public ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants() {
        return restaurantFeign.getAllRestaurants();
    }

    /**
     * Save the restaurants if the user is a ADMIN.
     */
    @Secured({"ADMIN"})
    @PostMapping("/")
    public ResponseEntity<Void> saveRestaurant(@RequestBody RestaurantRequestDto restaurantRequestDto) {
        return restaurantFeign.saveRestaurant(restaurantRequestDto);
    }

}
