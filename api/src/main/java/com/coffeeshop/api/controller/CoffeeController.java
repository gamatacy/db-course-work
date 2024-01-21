package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.coffee.CoffeeResponseDto;
import com.coffeeshop.api.mapper.CoffeeMapper;
import com.coffeeshop.api.service.CoffeeService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffee")
@RequiredArgsConstructor
public class CoffeeController {

    private final CoffeeMapper coffeeMapper;
    private final CoffeeService coffeeService;

    @PostMapping()
    @Operation(summary = "Создать кофе")
    public void createCoffee(@Valid @RequestBody CoffeeRequestDto coffeeRequestDto) {
        coffeeService.createCoffee(coffeeRequestDto.getBeans().getId(), coffeeRequestDto.getMilk() == null ? null : coffeeRequestDto.getMilk().getId(), coffeeRequestDto.getSyrup() == null ? null : coffeeRequestDto.getSyrup().getId(), coffeeRequestDto.getSize().getId());
    }

    @GetMapping("/bean")
    @Operation(summary = "Получить список зерен")
    public List<AdditiveResponseDto> getBeans() {
        return coffeeService.getBeans().stream().map(
                beansEntity -> new AdditiveResponseDto(beansEntity.getId(), beansEntity.getSort(), beansEntity.getPrice())
        ).toList();
    }

    @GetMapping("/milk")
    @Operation(summary = "Получить список видов молока")
    public List<AdditiveResponseDto> getMilks() {
        return coffeeService.getMilks().stream().map(
                milkEntity -> new AdditiveResponseDto(milkEntity.getId(), milkEntity.getName(), milkEntity.getPrice())
        ).toList();
    }

    @GetMapping("/syrup")
    @Operation(summary = "Получить список сиропов")
    public List<AdditiveResponseDto> getSyrups() {
        return coffeeService.getSyrups().stream().map(
                syrupEntity -> new AdditiveResponseDto(syrupEntity.getId(), syrupEntity.getName(), syrupEntity.getPrice())
        ).toList();
    }

    @GetMapping("/size")
    @Operation(summary = "Получить размеров кофе")
    public List<AdditiveResponseDto> getCoffeeSizes() {
        return coffeeService.getCoffeeSizes().stream().map(
                coffeeSizeEntity -> new AdditiveResponseDto(coffeeSizeEntity.getId(), coffeeSizeEntity.getName(), coffeeSizeEntity.getPrice())
        ).toList();
    }


    @GetMapping("/sale")
    @Operation(summary = "Получить список кофе по скидке")
    public List<CoffeeResponseDto> getCoffeeWithSale() {
        return coffeeService.getCoffeeWithSale().stream().map(
                coffeeMapper::coffeeEntityToCoffeeResponseDto
        ).toList();
    }


}
