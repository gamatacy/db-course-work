package com.coffeeshop.api.dto.shop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CatResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("age")
    private Integer age;
    @JsonProperty("gender")
    private Boolean gender;
    @JsonProperty("photo_url")
    private String photoUrl;
    @JsonProperty("shop")
    private ShopResponseDto shop;
}
