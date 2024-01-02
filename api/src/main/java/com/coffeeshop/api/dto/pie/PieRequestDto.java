package com.coffeeshop.api.dto.pie;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PieRequestDto {
    @Min(0)
    @JsonProperty("filling_id")
    private Long fillingId;
    @NotNull
    @Min(0)
    @JsonProperty("size_id")
    private Long sizeId;
}
