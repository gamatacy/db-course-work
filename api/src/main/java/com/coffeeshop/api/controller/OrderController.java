package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.order.OrderRequestDto;
import com.coffeeshop.api.dto.order.OrderResponseDto;
import com.coffeeshop.api.mapper.CoffeeMapper;
import com.coffeeshop.api.mapper.OrderMapper;
import com.coffeeshop.api.mapper.PieMapper;
import com.coffeeshop.api.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderMapper orderMapper;
    private final CoffeeMapper coffeeMapper;
    private final PieMapper pieMapper;
    private final OrderService orderService;

    @Transactional
    @PostMapping
    @Operation(summary = "Создать заказ")
    public OrderResponseDto createOrder(@Valid @RequestBody OrderRequestDto orderRequestDto) {
        System.out.println(orderRequestDto);
        return orderMapper.orderEntityToOrderResponseDto(
                orderService.createOrder(
                        orderRequestDto.getClientId(),
                        orderRequestDto.getAddress(),
                        orderRequestDto.getCoffee(),
                        orderRequestDto.getPies()
                )
        );
    }

    @GetMapping
    @Operation(summary = "Получить инофрмацию о заказе")
    public OrderResponseDto getOrder(@RequestParam("order_id") Long orderId) {
        return orderMapper.orderEntityToOrderResponseDto(
                orderService.getOrderById(orderId)
        );
    }

    @GetMapping("/all")
    @Operation(summary = "Получить инофрмацию о заказе")
    public List<OrderResponseDto> getOrders() {
        return orderService.getOrders().stream().map(orderMapper::orderEntityToOrderResponseDto).map(
                orderResponseDto -> {
                    Long id = orderResponseDto.getId();
                    orderResponseDto.setPrice(
                            orderService.calculatePrice(id)
                    );
                    return orderResponseDto;
                }
        ).toList();
    }


}
