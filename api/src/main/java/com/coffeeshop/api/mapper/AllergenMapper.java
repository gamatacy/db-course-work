package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.allergen.AllergenResponseDto;
import com.coffeeshop.api.model.AllergenEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AllergenMapper {

    AllergenResponseDto allergenEntityToAllergenResponseDto(AllergenEntity allergenEntity);

}
