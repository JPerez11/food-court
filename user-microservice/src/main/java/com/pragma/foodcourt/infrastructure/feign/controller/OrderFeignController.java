package com.pragma.foodcourt.infrastructure.feign.controller;

import com.pragma.foodcourt.infrastructure.feign.client.IOrderFeign;
import com.pragma.foodcourt.infrastructure.feign.dto.order.request.CreateDishOrderRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.order.request.CreateOrderRequestDto;
import com.pragma.foodcourt.infrastructure.feign.dto.order.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food-court/orders")
public class OrderFeignController {

    private final IOrderFeign orderFeign;

    @Secured({"EMPLOYEE"})
    @PostMapping("/order")
    public ResponseEntity<Void> createOrder(@RequestBody CreateOrderRequestDto createOrderRequestDto) {
        return orderFeign.createOrder(createOrderRequestDto);
    }

    @Secured({"EMPLOYEE"})
    @PostMapping("/dish-order")
    public ResponseEntity<Void> createDishOrder(@RequestBody CreateDishOrderRequestDto createDishOrderRequestDto) {
        return orderFeign.createDishOrder(createDishOrderRequestDto);
    }

    @Secured({"EMPLOYEE"})
    @GetMapping("/")
    public List<OrderResponse> getOrders(@RequestParam String status, @RequestParam Long idRestaurant) {
        return orderFeign.getOrders(status, idRestaurant);
    }

    @Secured({"EMPLOYEE"})
    @GetMapping("/paginated")
    public Page<OrderResponse> getOrdersPaginated(@RequestParam String status, @RequestParam Long idRestaurant,
                                                  @RequestParam(name = "content", defaultValue = "0") int pageNumber,
                                                  @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        return orderFeign.getOrdersPaginated(status, idRestaurant, pageNumber, pageSize);
    }

}
