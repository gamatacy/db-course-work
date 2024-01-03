package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.coffeeshop.api.dto.pie.PieResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pie")
@RequiredArgsConstructor
public class PieController {

    @PostMapping()
    @Operation(summary = "Создать кастомный пирожок")
    public PieResponseDto createPie(@Valid @RequestBody PieRequestDto pieRequestDto) {
        return null;
    }

    @GetMapping("/filling")
    @Operation(summary = "Получить начинки")
    public List<AdditiveResponseDto> getFillings() {
        return null;
    }

    @GetMapping("/size")
    @Operation(summary = "Получить размеры пирожков")
    public List<AdditiveResponseDto> getCoffeeSizes() {
        return null;
    }

    @GetMapping("/sale")
    @Operation(summary = "Получить список пирожков по скидке")
    public List<PieResponseDto> getPiesWithSale() {
        return null;
    }


}
