package com.ohgiraffers.adregamdi.review.application.service;

import com.ohgiraffers.adregamdi.review.domain.service.DeleteReviewService;
import com.ohgiraffers.adregamdi.review.domain.service.InsertReviewService;
import com.ohgiraffers.adregamdi.review.domain.service.UpdateReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    private InsertReviewService insertReviewService;
    private UpdateReviewService updateReviewService;
    private DeleteReviewService deleteReviewService;

    @Autowired
    public ReviewService(InsertReviewService insertReviewService, UpdateReviewService updateReviewService, DeleteReviewService deleteReviewService) {
        this.insertReviewService = insertReviewService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
    }

    public void insertReview() {
        insertReviewService.insertReview();
    }

    public void updateReview() {
        updateReviewService.updateReview();
    }

    public void deleteReview() {
        deleteReviewService.deleteReview();
    }
}
