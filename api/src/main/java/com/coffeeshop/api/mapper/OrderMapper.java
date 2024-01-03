package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.order.OrderRequestDto;
import com.coffeeshop.api.dto.order.OrderResponseDto;
import com.coffeeshop.api.model.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CoffeeMapper.class, PieMapper.class, ClientMapper.class})
public interface OrderMapper {

    OrderEntity orderRequestDtoToOrderEntity(OrderRequestDto orderRequestDto);

    OrderResponseDto orderEntityToOrderResponseDto(OrderEntity orderEntity);

}
