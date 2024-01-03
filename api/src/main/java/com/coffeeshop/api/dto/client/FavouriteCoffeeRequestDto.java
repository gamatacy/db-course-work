package com.coffeeshop.api.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class FavouriteCoffeeRequestDto {
    @NotNull
    @Min(0)
    @JsonProperty("client_id")
    private Long clientId;
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
