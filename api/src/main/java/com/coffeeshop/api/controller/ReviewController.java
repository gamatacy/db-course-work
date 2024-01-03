package com.coffeeshop.api.controller;

import com.coffeeshop.api.dto.review.ReviewRequestDto;
import com.coffeeshop.api.dto.review.ReviewResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
@RequiredArgsConstructor
public class ReviewController {

    @GetMapping
    @Operation(summary = "Посмотреть отзывы")
    public List<ReviewResponseDto> getReviews() {
        return null;
    }

    @PostMapping
    @Operation(summary = "Создать отзыв")
    public ReviewResponseDto createReview(@Valid @RequestBody ReviewRequestDto reviewRequestDto) {
        return null;
    }

}
