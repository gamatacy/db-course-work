package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.shop.CatResponseDto;
import com.coffeeshop.api.dto.shop.ShopResponseDto;
import com.coffeeshop.api.mapper.ShopMapper;
import com.coffeeshop.api.service.ShopService;
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

    private final ShopService shopService;
    private final ShopMapper shopMapper;

    @GetMapping("/cats")
    @Operation(summary = "Посмотреть котов в магазине")
    public List<CatResponseDto> getShopCats(@RequestParam("shop_id") Long shopId) {
        return shopService.getCatsByShopId(shopId).stream().map(shopMapper::catEntityToCatResponseDto).toList();
    }

    @GetMapping()
    @Operation(summary = "Посмотреть магазины")
    public List<ShopResponseDto> getShops() {
        return shopService.getShops().stream().map(shopMapper::shopEntityToShopResponseDto).toList();
    }

}
