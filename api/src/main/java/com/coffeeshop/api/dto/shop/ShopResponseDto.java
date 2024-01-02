package com.coffeeshop.api.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ShopResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("shop")
    private String address;
}
