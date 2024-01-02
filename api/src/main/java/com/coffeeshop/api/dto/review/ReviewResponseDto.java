package com.coffeeshop.api.dto.review;

import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ReviewResponseDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("rating")
    private Long rating;
    @JsonProperty("text")
    private String text;
    @JsonProperty("date")
    private String date;
    @JsonProperty("client")
    private ClientResponseDto client;
}
