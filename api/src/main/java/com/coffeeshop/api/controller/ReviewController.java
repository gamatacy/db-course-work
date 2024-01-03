package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.review.ReviewRequestDto;
import com.coffeeshop.api.dto.review.ReviewResponseDto;
import com.coffeeshop.api.mapper.ReviewMapper;
import com.coffeeshop.api.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    @GetMapping
    @Operation(summary = "Посмотреть отзывы")
    public List<ReviewResponseDto> getReviews() {
        return reviewService.getReviews().stream().map(
                reviewMapper::reviewEntityToReviewResponseDto
        ).toList();
    }

    @PostMapping
    @Operation(summary = "Создать отзыв")
    public ReviewResponseDto createReview(@Valid @RequestBody ReviewRequestDto reviewRequestDto) {
        return reviewMapper.reviewEntityToReviewResponseDto(
                reviewService.createReview(
                        reviewRequestDto.getClientId(),
                        reviewRequestDto.getRating(),
                        reviewRequestDto.getText()
                )
        );
    }

}
