package com.pragma.foodcourt.infrastructure.feign.client;

import com.pragma.foodcourt.infrastructure.feign.dto.RestaurantResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "restaurant", url = "localhost:8091/api/food-court/restaurant")
public interface IRestaurantFeign {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    ResponseEntity<List<RestaurantResponseDto>> getAllRestaurants();


}
