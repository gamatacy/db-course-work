package com.coffeeshop.api.repository;

import com.coffeeshop.api.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {

    @Query(value = """
            SELECT * FROM review_jn
            """, nativeQuery = true)
    List<ReviewEntity> getReviews();


    @Query(value = """
            INSERT INTO review_jn (client_id, rating, review_text) VALUES (:client_id, :rating, :review_text) RETURNING *
            """, nativeQuery = true)
    ReviewEntity createReview(@Param("client_id") Integer clientId, @Param("rating") Integer rating, @Param("review_text") String text);


}
