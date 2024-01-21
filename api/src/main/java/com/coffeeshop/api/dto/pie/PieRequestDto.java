package com.coffeeshop.api.dto.pie;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class PieRequestDto {
    @Min(0)
    @JsonProperty("filling")
    private AdditiveResponseDto filling;
    @NotNull
    @Min(0)
    @JsonProperty("size")
    private AdditiveResponseDto size;
}
