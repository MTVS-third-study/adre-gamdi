package com.ohgiraffers.adregamdi.review.domain.service;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public CreateReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void createReview(ReviewDTO reviewDTO) {
        reviewRepository.saveReviewInDB(reviewDTO);

    }
}
