package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.shop.CatResponseDto;
import com.coffeeshop.api.dto.shop.ShopResponseDto;
import com.coffeeshop.api.model.CatEntity;
import com.coffeeshop.api.model.ShopEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    CatResponseDto catEntityToCatResponseDto(CatEntity catEntity);

    ShopResponseDto shopEntityToShopResponseDto(ShopEntity shopEntity);

}
