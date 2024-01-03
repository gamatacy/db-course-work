package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.shop.CatResponseDto;
import com.coffeeshop.api.model.CatEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopMapper {

    CatResponseDto catEntityToCatResponseDto(CatEntity catEntity);

}
