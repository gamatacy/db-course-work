package com.coffeeshop.api.dto.pie;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PieResponseDto {
    @NotNull
    @JsonProperty("id")
    private Long id;
    @JsonProperty("filling")
    private AdditiveResponseDto filling;
    @NotNull
    @JsonProperty("size")
    private AdditiveResponseDto size;

}
