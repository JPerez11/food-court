package com.pragma.foodcourt.infrastructure.feign.client;

import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.SaveDishRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.UpdateDishRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.request.UpdateDishStatusRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.dish.response.ReadDishResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "dish", url = "localhost:8091/api/food-court/dish")
public interface IDishFeign {

    @GetMapping("/")
    ResponseEntity<List<ReadDishResponseDto>> getDishes();

    @GetMapping("{id}")
    ResponseEntity<List<ReadDishResponseDto>> readDish(@PathVariable Long id);

    @PostMapping("/")
    ResponseEntity<Void> saveDish(@RequestBody SaveDishRequestDto saveDishRequestDto);

    @PutMapping("/update")
    ResponseEntity<Void> updateDish(@RequestBody UpdateDishRequestDto updateDishRequest);

    @PutMapping("/status")
    ResponseEntity<Void> updateDishStatus(@RequestBody UpdateDishStatusRequestDto updateDishStatusRequest);

}
