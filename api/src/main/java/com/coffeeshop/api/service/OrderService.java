package com.coffeeshop.api.service;

import com.coffeeshop.api.model.CoffeeEntity;
import com.coffeeshop.api.model.OrderEntity;
import com.coffeeshop.api.model.PieEntity;
import com.coffeeshop.api.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderEntity createOrder(Long clientId, String address, List<CoffeeEntity> coffee, List<PieEntity> pies) {

        var orderId = orderRepository.createOrder(Math.toIntExact(clientId), address);
        coffee.forEach(coffeeEntity -> orderRepository.addCoffeeToOrder(Math.toIntExact(orderId), Math.toIntExact(coffeeEntity.getId())));
        pies.forEach(pieEntity -> orderRepository.addCoffeeToOrder(Math.toIntExact(orderId), Math.toIntExact(pieEntity.getId())));
        return getOrderById(orderId);

    }

    public OrderEntity getOrderById(Long orderId) {
        return orderRepository.getOrderById(Math.toIntExact(orderId));
    }


}
