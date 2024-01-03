package com.coffeeshop.api.service;

import com.coffeeshop.api.model.ReviewEntity;
import com.coffeeshop.api.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewEntity> getReviews() {
        return reviewRepository.getReviews();
    }

    public ReviewEntity createReview(Long clientId, Long rating, String text) {
        return reviewRepository.createReview(Math.toIntExact(clientId), Math.toIntExact(rating), text);
    }

}
