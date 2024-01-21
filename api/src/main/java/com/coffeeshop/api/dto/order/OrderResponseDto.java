package com.coffeeshop.api.dto.order;

import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.coffee.CoffeeResponseDto;
import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.coffeeshop.api.dto.pie.PieResponseDto;
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
    @JsonProperty("status")
    private StatusEntityResponseDto status;
    @NotNull
    @JsonProperty("client")
    private ClientResponseDto client;
    @JsonProperty("coffee")
    private List<CoffeeResponseDto> coffee;
    @JsonProperty("pies")
    private List<PieResponseDto> pies;
}
