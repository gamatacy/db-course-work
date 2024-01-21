package com.coffeeshop.api.dto.coffee;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoffeeRequestDto {
    @NotNull
    @Min(0)
    @JsonProperty("bean")
    private AdditiveResponseDto beans;
    @Min(0)
    @JsonProperty("milk")
    private AdditiveResponseDto milk;
    @Min(0)
    @JsonProperty("syrup")
    private AdditiveResponseDto syrup;
    @NotNull
    @Min(0)
    @JsonProperty("size")
    private AdditiveResponseDto size;
}
