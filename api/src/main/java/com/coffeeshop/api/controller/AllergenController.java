package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.allergen.AllergenResponseDto;
import com.coffeeshop.api.mapper.AllergenMapper;
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

    @GetMapping("/milk")
    @Operation(summary = "Аллергены молока")
    public List<AllergenResponseDto> getMilkAllergens(@RequestParam("milk_id") Long milkId) {
        return null;
    }

    @GetMapping("/syrup")
    @Operation(summary = "Аллергены сиропа")
    public List<AllergenResponseDto> getSyrupAllergens(@RequestParam("syrup_id") Long syrupId) {
        return null;
    }

    @GetMapping("/filling")
    @Operation(summary = "Аллергены начинок")
    public List<AllergenResponseDto> getFillingAllergens(@RequestParam("filling_id") Long fillingId) {
        return null;
    }

}
