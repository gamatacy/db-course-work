package com.coffeeshop.api.dto.order;

import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("price")
    private Long price;
    @NotNull
    @JsonProperty("address")
    private String address;
    @NotNull
    @JsonProperty("client")
    private ClientResponseDto client;
    @JsonProperty("coffee")
    private List<CoffeeRequestDto> coffee;
    @JsonProperty("pies")
    private List<PieRequestDto> pies;
}
