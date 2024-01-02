package com.coffeeshop.api.dto.coffee;


import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoffeeResponseDto {
    @NotNull
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("beans")
    private AdditiveResponseDto beans;
    @JsonProperty("milk")
    private AdditiveResponseDto milk;
    @JsonProperty("syrup")
    private AdditiveResponseDto syrup;
    @NotNull
    @JsonProperty("size")
    private AdditiveResponseDto size;
}
