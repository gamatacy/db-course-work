package com.coffeeshop.api.service;

import com.coffeeshop.api.model.*;
import com.coffeeshop.api.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;
    private final BeansRepository beansRepository;
    private final MilkRepository milkRepository;
    private final SyrupRepository syrupRepository;
    private final CoffeeSizeRepository coffeeSizeRepository;


    public void createCoffee(Long beansId, Long milkId, Long syrupId, Long sizeId) {
        coffeeRepository.createCoffee(milkId == null ? null : Math.toIntExact(milkId), Math.toIntExact(beansId), syrupId == null ? null : Math.toIntExact(syrupId), Math.toIntExact(sizeId));
    }

    public List<BeansEntity> getBeans() {
        return beansRepository.getBeans();
    }

    public List<MilkEntity> getMilks() {
        return milkRepository.getMilks();
    }

    public List<SyrupEntity> getSyrups() {
        return syrupRepository.getSyrups();
    }

    public List<CoffeeSizeEntity> getCoffeeSizes() {
        return coffeeSizeRepository.getCoffeeSizes();
    }

    public List<CoffeeEntity> getCoffeeWithSale() {
        return coffeeRepository.getCoffeeWithSale();
    }

}
