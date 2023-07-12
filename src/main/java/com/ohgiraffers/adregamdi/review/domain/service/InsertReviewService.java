package com.ohgiraffers.adregamdi.review.domain.service;

import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public InsertReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void insertReview() {
        reviewRepository.saveReviewInDB();

    }
}
