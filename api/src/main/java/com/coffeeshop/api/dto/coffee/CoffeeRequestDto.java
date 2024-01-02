package com.coffeeshop.api.dto.coffee;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CoffeeRequestDto {
    @NotNull
    @Min(0)
    @JsonProperty("beans_id")
    private Long beansId;
    @Min(0)
    @JsonProperty("milk_id")
    private Long milkId;
    @Min(0)
    @JsonProperty("syrup_id")
    private Long syrupId;
    @NotNull
    @Min(0)
    @JsonProperty("size_id")
    private Long sizeId;
}
