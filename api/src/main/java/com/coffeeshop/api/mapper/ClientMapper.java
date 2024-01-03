package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.client.ClientRequestDto;
import com.coffeeshop.api.dto.client.ClientResponseDto;
import com.coffeeshop.api.model.ClientEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CoffeeMapper.class})
public interface ClientMapper {

    ClientResponseDto clientEntityToClientResponseDto(ClientEntity clientEntity);

    ClientEntity clientRequestDtoToClientEntity(ClientRequestDto clientRequestDto);


}
