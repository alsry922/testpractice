package com.alsry.testcodepractice.spring.api.controller.order;

import com.alsry.testcodepractice.spring.api.controller.order.request.OrderCreateRequest;
import com.alsry.testcodepractice.spring.api.service.order.OrderService;
import com.alsry.testcodepractice.spring.api.service.order.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/orders/new")
    public OrderResponse createOrder(@RequestBody OrderCreateRequest orderCreateRequest) {
        LocalDateTime registeredDateTime = LocalDateTime.now();
        OrderResponse orderResponse = orderService.createOrder(orderCreateRequest, registeredDateTime);
        return orderResponse;
    }
}

