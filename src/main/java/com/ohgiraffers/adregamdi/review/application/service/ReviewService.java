package com.ohgiraffers.adregamdi.review.application.service;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.service.DeleteReviewService;
import com.ohgiraffers.adregamdi.review.domain.service.CreateReviewService;
import com.ohgiraffers.adregamdi.review.domain.service.UpdateReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private CreateReviewService createReviewService;
    private UpdateReviewService updateReviewService;
    private DeleteReviewService deleteReviewService;

    @Autowired
    public ReviewService(CreateReviewService createReviewService, UpdateReviewService updateReviewService, DeleteReviewService deleteReviewService) {
        this.createReviewService = createReviewService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
    }

    public void insertReview(ReviewDTO reviewDTO) {
        createReviewService.createReview(reviewDTO);
    }

    public void updateReview() {
        updateReviewService.updateReview();
    }

    public void deleteReview() {
        deleteReviewService.deleteReview();
    }
}
