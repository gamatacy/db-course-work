package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.pie.PieRequestDto;
import com.coffeeshop.api.dto.pie.PieResponseDto;
import com.coffeeshop.api.model.PieEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PieMapper {

    PieResponseDto pieEntityToPieResponseDto(PieEntity pieEntity);

    PieEntity pieRequestDtoToPieEntity(PieRequestDto pieRequestDto);

}
