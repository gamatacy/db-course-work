package com.coffeeshop.api.dto.client;

import com.coffeeshop.api.dto.coffee.CoffeeResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ClientResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("registration_date")
    private String registrationDate;
    @JsonProperty("favourite_coffee")
    private CoffeeResponseDto favouriteCoffee;
}
