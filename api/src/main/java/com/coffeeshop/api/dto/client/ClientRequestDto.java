package com.coffeeshop.api.dto.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ClientRequestDto {
    @NotNull
    @JsonProperty("name")
    private String name;
    @NotNull
    @JsonProperty("password")
    private String password;
}
