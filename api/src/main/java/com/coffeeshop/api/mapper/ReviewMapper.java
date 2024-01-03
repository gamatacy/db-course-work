package com.coffeeshop.api.mapper;

import com.coffeeshop.api.dto.review.ReviewRequestDto;
import com.coffeeshop.api.dto.review.ReviewResponseDto;
import com.coffeeshop.api.model.ReviewEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface ReviewMapper {

    ReviewResponseDto reviewEntityToReviewResponseDto(ReviewEntity reviewEntity);

    ReviewEntity reviewRequestDtoToReviewEntity(ReviewRequestDto reviewRequestDto);

}
