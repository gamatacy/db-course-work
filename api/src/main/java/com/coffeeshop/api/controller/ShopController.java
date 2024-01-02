package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.shop.CatResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/shop")
@RequiredArgsConstructor
public class ShopController {

    @GetMapping("/cats")
    @Operation(summary = "Посмотреть котов в магазине")
    public List<CatResponseDto> getShopCats(@RequestParam("shop_id") Long shopId) {
        return null;
    }

}
