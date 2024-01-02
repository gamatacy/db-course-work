package com.coffeeshop.api.dto.review;

import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ReviewRequestDto {
    @NotNull
    @Min(0)
    @Max(5)
    @JsonProperty("rating")
    private Long rating;
    @JsonProperty("text")
    private String text;
    @NotNull
    @JsonProperty("client_id")
    private Long clientId;
}
