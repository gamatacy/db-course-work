package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.order.OrderRequestDto;
import com.coffeeshop.api.dto.order.OrderResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    @PostMapping
    @Operation(summary = "Создать заказ")
    public OrderResponseDto createOrder(@Valid OrderRequestDto orderRequestDto) {
        return null;
    }

    @GetMapping
    @Operation(summary = "Получить инофрмацию о заказе")
    public OrderResponseDto getOrder(@RequestParam("order_id") Long orderId) {
        return null;
    }


}
