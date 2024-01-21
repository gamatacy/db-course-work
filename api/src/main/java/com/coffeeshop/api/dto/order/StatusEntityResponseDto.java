package com.coffeeshop.api.dto.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class StatusEntityResponseDto {

    @JsonProperty("name")
    private String name;

}