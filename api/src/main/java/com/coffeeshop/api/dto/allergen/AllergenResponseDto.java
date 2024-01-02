package com.coffeeshop.api.dto.allergen;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AllergenResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
}
