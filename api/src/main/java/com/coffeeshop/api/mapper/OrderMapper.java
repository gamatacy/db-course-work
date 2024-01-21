package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.order.OrderRequestDto;
import com.coffeeshop.api.dto.order.OrderResponseDto;
import com.coffeeshop.api.dto.order.StatusEntityResponseDto;
import com.coffeeshop.api.model.OrderEntity;
import com.coffeeshop.api.model.StatusEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {CoffeeMapper.class, PieMapper.class, ClientMapper.class})
public interface OrderMapper {

    OrderEntity orderRequestDtoToOrderEntity(OrderRequestDto orderRequestDto);

    OrderResponseDto orderEntityToOrderResponseDto(OrderEntity orderEntity);

    StatusEntityResponseDto statusEntityToStatusEntityResponseDto(StatusEntity statusEntity);

}
