package com.ohgiraffers.adregamdi.review.domain.repository;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewRepository {
    public void saveReviewInDB(ReviewDTO reviewDTO) {
        Review review = new Review(reviewDTO.getReviewNo(), reviewDTO.getLikeNum(),
                reviewDTO.getStarPoint(), reviewDTO.getReviewImage(),
                reviewDTO.getReviewContent(), reviewDTO.getRegDate(),
                reviewDTO.getReviewWriterNo(), reviewDTO.getReviewPlaceNo());
    }
}
