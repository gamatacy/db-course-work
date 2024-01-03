package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.allergen.AllergenResponseDto;
import com.coffeeshop.api.mapper.AllergenMapper;
import com.coffeeshop.api.service.AllergenService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/allergen")
@RequiredArgsConstructor
public class AllergenController {

    private final AllergenMapper allergenMapper;
    private final AllergenService allergenService;

    @GetMapping("/milk")
    @Operation(summary = "Аллергены молока")
    public List<AllergenResponseDto> getMilkAllergens(@RequestParam("milk_id") Long milkId) {
        return allergenService.getMilkAllergens(milkId).stream().map(allergenMapper::allergenEntityToAllergenResponseDto).toList();
    }

    @GetMapping("/syrup")
    @Operation(summary = "Аллергены сиропа")
    public List<AllergenResponseDto> getSyrupAllergens(@RequestParam("syrup_id") Long syrupId) {
        return allergenService.getSyrupAllergens(syrupId).stream().map(allergenMapper::allergenEntityToAllergenResponseDto).toList();
    }

    @GetMapping("/filling")
    @Operation(summary = "Аллергены начинок")
    public List<AllergenResponseDto> getFillingAllergens(@RequestParam("filling_id") Long fillingId) {
        return allergenService.getFillingAllergens(fillingId).stream().map(allergenMapper::allergenEntityToAllergenResponseDto).toList();
    }

}
