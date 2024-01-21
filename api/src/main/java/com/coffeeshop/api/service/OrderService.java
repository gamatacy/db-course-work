package com.coffeeshop.api.service;

import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.coffeeshop.api.model.CoffeeEntity;
import com.coffeeshop.api.model.OrderEntity;
import com.coffeeshop.api.model.PieEntity;
import com.coffeeshop.api.repository.CoffeeRepository;
import com.coffeeshop.api.repository.OrderRepository;
import com.coffeeshop.api.repository.PieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CoffeeRepository coffeeRepository;
    private final PieRepository pieRepository;

    public OrderEntity createOrder(Long clientId, String address, List<CoffeeRequestDto> coffee, List<PieRequestDto> pies) {

        var orderId = orderRepository.createOrder(Math.toIntExact(clientId), address);

        coffee.forEach(coffeee -> {
            var coffiez = coffeeRepository.getCoffee(coffeee.getMilk() == null ? null : Math.toIntExact(coffeee.getMilk().getId()), coffeee.getBeans() == null ? null : Math.toIntExact(coffeee.getBeans().getId()), coffeee.getSyrup() == null ? null : Math.toIntExact(coffeee.getSyrup().getId()), coffeee.getSize() == null ? null : Math.toIntExact(coffeee.getSize().getId()));
            System.out.println("coffiez");
            System.out.println(coffiez);
            coffiez.forEach(coffeeEntity -> orderRepository.addCoffeeToOrder(Math.toIntExact(orderId), Math.toIntExact(coffeeEntity.getId())));
        });
        pies.forEach(pie -> {
            var piez = pieRepository.getPiesBy(Math.toIntExact(pie.getFilling().getId()), Math.toIntExact(pie.getSize().getId()));
            System.out.println("piez");
            System.out.println(piez);
            piez.forEach(pieEntity -> orderRepository.addPieToOrder(Math.toIntExact(orderId), Math.toIntExact(pieEntity.getId())));
        });

        orderRepository.addBp(Math.toIntExact(clientId), coffee.size() * 25 + pies.size() * 25);

        return getOrderById(orderId);

    }

    public OrderEntity getOrderById(Long orderId) {
        return orderRepository.getOrderById(Math.toIntExact(orderId));
    }

    public List<OrderEntity> getOrders() {
        return orderRepository.getAllOrders();
    }

    public Long calculatePrice(Long orderId){
        return orderRepository.calculatePrice(Math.toIntExact(orderId));
    }


}
