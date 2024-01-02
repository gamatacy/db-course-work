package com.coffeeshop.api.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SpendBonusPointsRequestDto {
    @NotNull
    @JsonProperty("client_id")
    private Long clientId;
    @NotNull
    @Min(0)
    @JsonProperty("bonus_points")
    private Long bonusPoints;
}
