package com.pragma.foodcourt.infrastructure.feign.controller;

import com.pragma.foodcourt.infrastructure.feign.client.IDishFeign;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.SaveDishRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.UpdateDishRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.UpdateDishStatusRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.response.ReadDishResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Controller feign dish.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/dish")
public class DishFeignController {

    private final IDishFeign dishFeign;

    /**
     * Gets the dishes if the user is a CUSTOMER.
     */
    @Secured({"CUSTOMER"})
    @GetMapping("/")
    public ResponseEntity<List<ReadDishResponseDto>> getDishes() {
        return dishFeign.getDishes();
    }

    /**
     * Gets the dishes from a restaurant if the user is a CUSTOMER.
     */
    @Secured({"CUSTOMER"})
    @GetMapping("{id}")
    public ResponseEntity<List<ReadDishResponseDto>> readDish(@PathVariable Long id) {
        return dishFeign.readDish(id);
    }

    /**
     * Save the dish if the user is a OWNER.
     */
    @Secured({"OWNER"})
    @PostMapping("/")
    public ResponseEntity<Void> saveDish(@RequestBody SaveDishRequestDto saveDishRequestDto) {
        return dishFeign.saveDish(saveDishRequestDto);
    }

    /**
     * Update the dish if the user is a OWNER.
     */
    @Secured({"OWNER"})
    @PutMapping("/update")
    public ResponseEntity<Void> updateDish(@RequestBody UpdateDishRequestDto updateDishRequest) {
        return dishFeign.updateDish(updateDishRequest);
    }

    /**
     * Update the dish status if the user is a OWNER.
     */
    @Secured({"OWNER"})
    @PutMapping("/status")
    public ResponseEntity<Void> updateDishStatus(@RequestBody UpdateDishStatusRequestDto updateDishStatusRequest) {
        return dishFeign.updateDishStatus(updateDishStatusRequest);
    }

}
