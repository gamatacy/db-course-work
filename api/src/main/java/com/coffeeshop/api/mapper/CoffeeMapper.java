package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.coffee.CoffeeRequestDto;
import com.coffeeshop.api.dto.coffee.CoffeeResponseDto;
import com.coffeeshop.api.model.CoffeeEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CoffeeMapper {

    CoffeeResponseDto coffeeEntityToCoffeeResponseDto(CoffeeEntity coffeeEntity);

    CoffeeEntity coffeeRequestDtoToCoffeeEntity(CoffeeRequestDto coffeeRequestDto);

}
