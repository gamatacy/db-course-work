package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.AdditiveResponseDto;
import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.coffeeshop.api.dto.pie.PieResponseDto;
import com.coffeeshop.api.mapper.PieMapper;
import com.coffeeshop.api.service.PieService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pie")
@RequiredArgsConstructor
public class PieController {

    private final PieMapper pieMapper;
    private final PieService pieService;

    @PostMapping()
    @Operation(summary = "Создать кастомный пирожок")
    public PieResponseDto createPie(@Valid @RequestBody PieRequestDto pieRequestDto) {
        return pieMapper.pieEntityToPieResponseDto(pieService.createPie(pieRequestDto.getFillingId(), pieRequestDto.getSizeId()));
    }

    @GetMapping("/filling")
    @Operation(summary = "Получить начинки")
    public List<AdditiveResponseDto> getFillings() {
        return pieService.getFillings().stream().map(
                fillingEntity -> new AdditiveResponseDto(fillingEntity.getId(), fillingEntity.getName(), fillingEntity.getPrice())
        ).toList();
    }

    @GetMapping("/size")
    @Operation(summary = "Получить размеры пирожков")
    public List<AdditiveResponseDto> getCoffeeSizes() {
        return pieService.getPieSizes().stream().map(
                pieSizeEntity -> new AdditiveResponseDto(pieSizeEntity.getId(), pieSizeEntity.getName(), pieSizeEntity.getPrice())
        ).toList();
    }

    @GetMapping("/sale")
    @Operation(summary = "Получить список пирожков по скидке")
    public List<PieResponseDto> getPiesWithSale() {
        return pieService.getPiesWithSale().stream().map(
                pieMapper::pieEntityToPieResponseDto
        ).toList();
    }


}
