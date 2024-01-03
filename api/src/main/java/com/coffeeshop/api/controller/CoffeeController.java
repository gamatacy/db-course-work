package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.coffee.CoffeeResponseDto;
import com.coffeeshop.api.mapper.CoffeeMapper;
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

    @PostMapping()
    @Operation(summary = "Создать кофе")
    public CoffeeResponseDto createCoffee(@Valid @RequestBody CoffeeRequestDto coffeeRequestDto) {
        return null;
    }

    @GetMapping("/bean")
    @Operation(summary = "Получить список зерен")
    public List<AdditiveResponseDto> getBeans() {
        return null;
    }

    @GetMapping("/milk")
    @Operation(summary = "Получить список видов молока")
    public List<AdditiveResponseDto> getMilks() {
        return null;
    }

    @GetMapping("/syrup")
    @Operation(summary = "Получить список сиропов")
    public List<AdditiveResponseDto> getSyrups() {
        return null;
    }

    @GetMapping("/size")
    @Operation(summary = "Получить размеров кофе")
    public List<AdditiveResponseDto> getCoffeeSizes() {
        return null;
    }


    @GetMapping("/sale")
    @Operation(summary = "Получить список кофе по скидке")
    public List<CoffeeResponseDto> getCoffeeWithSale() {
        return null;
    }


}
