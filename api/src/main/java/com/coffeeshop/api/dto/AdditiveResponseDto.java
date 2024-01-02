package com.coffeeshop.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AdditiveResponseDto {
    @NotNull
    @Min(0)
    @JsonProperty("id")
    private Long id;
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @Min(0)
    @JsonProperty("price")
    private Long price;
}
