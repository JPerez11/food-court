package com.pragma.foodcourt.infrastructure.feign.client;

import com.pragma.foodcourt.infrastructure.feign.dto.order.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.order.request.CreateOrderRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.order.response.OrderResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Feign client for microservice orders.
 */
@FeignClient(name = "order", url = "localhost:8091/api/food-court/orders")
public interface IOrderFeign {

    //Save order.
    @PostMapping("/order")
    ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto);

    //Save order detail.
    @PostMapping("/dish-order")
    ResponseEntity<Void> createDishOrder(@RequestBody CreateDishOrderRequestDto createDishOrderRequestDto);

    //Gets the order sorted by status.
    @GetMapping("/")
    List<OrderResponse> getOrders(@RequestParam String status, @RequestParam Long idRestaurant);

    //Gets the order sorted by status and paginates it.
    @GetMapping("/paginated")
    Page<OrderResponse> getOrdersPaginated(@RequestParam String status, @RequestParam Long idRestaurant,
                                           @RequestParam(name = "content", defaultValue = "0") int pageNumber,
                                           @RequestParam(name = "size", defaultValue = "10") int pageSize);
}
