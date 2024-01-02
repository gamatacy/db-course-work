package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.client.ClientRequestDto;
import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.coffeeshop.api.dto.client.SpendBonusPointsRequestDto;
import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    @PostMapping("/registration")
    @Operation(summary = "Регистрация клиента")
    public ClientResponseDto registerClient(@Valid ClientRequestDto clientRequestDto) {
        return null;
    }

    @PostMapping("/login")
    @Operation(summary = "Авторизация клиента")
    public ClientResponseDto authorizeClient(@Valid ClientRequestDto clientRequestDto) {
        return null;
    }

    @GetMapping("/bonus-points")
    @Operation(summary = "Просмотр баллов клиента")
    public Long getClientBonusPoints(@RequestParam Long id) {
        return 1L;
    }

    @PostMapping("/bonus-points")
    @Operation(summary = "Потратить баллы клиента")
    public ResponseEntity<Object> spendBonusPoints(@Valid SpendBonusPointsRequestDto spendBonusPointsRequestDto) {
        return null;
    }

    @PostMapping("/favourite-coffee")
    @Operation(summary = "Сохранить любимый кофе клиента")
    public ResponseEntity<Object> saveFavouriteCoffee(@Valid CoffeeRequestDto coffeeRequestDto) {
        return null;
    }

}
