package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.client.ClientRequestDto;
import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.coffeeshop.api.dto.client.FavouriteCoffeeRequestDto;
import com.coffeeshop.api.dto.client.SpendBonusPointsRequestDto;
import com.coffeeshop.api.mapper.ClientMapper;
import com.coffeeshop.api.mapper.CoffeeMapper;
import com.coffeeshop.api.model.ClientEntity;
import com.coffeeshop.api.service.ClientService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {

    private final ClientMapper clientMapper;
    private final CoffeeMapper coffeeMapper;

    private final ClientService clientService;

    @PostMapping("/registration")
    @Operation(summary = "Регистрация клиента")
    public ClientResponseDto registerClient(@Valid @RequestBody ClientRequestDto clientRequestDto) throws Exception {
        System.out.println(clientRequestDto);
        ClientEntity client = clientService.register(clientRequestDto.getName(), clientRequestDto.getPassword());
        return clientMapper.clientEntityToClientResponseDto(client);
    }

    @PostMapping("/login")
    @Operation(summary = "Авторизация клиента")
    public ClientResponseDto authorizeClient(@Valid @RequestBody ClientRequestDto clientRequestDto) throws Exception {
        ClientEntity client = clientService.login(clientRequestDto.getName(), clientRequestDto.getPassword());
        return clientMapper.clientEntityToClientResponseDto(client);
    }

    @GetMapping("/bonus-points")
    @Operation(summary = "Просмотр баллов клиента")
    public Long getClientBonusPoints(@RequestParam Long id) throws Exception {
        return clientService.getBonusPoints(id);
    }

    @PostMapping("/bonus-points")
    @Operation(summary = "Потратить баллы клиента")
    public void spendBonusPoints(@Valid @RequestBody SpendBonusPointsRequestDto spendBonusPointsRequestDto) {
        clientService.spendPoints(spendBonusPointsRequestDto.getClientId(), spendBonusPointsRequestDto.getBonusPoints());
    }

    @PostMapping("/favourite-coffee")
    @Operation(summary = "Сохранить любимый кофе клиента")
    public void saveFavouriteCoffee(@Valid @RequestBody FavouriteCoffeeRequestDto favouriteCoffeeRequestDto) {
        clientService.saveFavouriteCoffee(favouriteCoffeeRequestDto.getClientId(), favouriteCoffeeRequestDto.getBeansId(), favouriteCoffeeRequestDto.getMilkId(), favouriteCoffeeRequestDto.getSyrupId(), favouriteCoffeeRequestDto.getSizeId());
    }

}
