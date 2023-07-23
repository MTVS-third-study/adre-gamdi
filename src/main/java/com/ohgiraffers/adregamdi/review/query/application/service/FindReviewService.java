package com.ohgiraffers.adregamdi.review.query.application.service;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.query.infra.repository.ReviewQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindReviewService {

    private ReviewQueryRepository reviewQueryRepository;

    @Autowired
    public FindReviewService(ReviewQueryRepository reviewQueryRepository) {
        this.reviewQueryRepository = reviewQueryRepository;
    }

    public List<Review> getReviewList(Long reviewPlaceNo) {
        List<Review> reviewList = reviewQueryRepository.findByReviewPlaceNo(new ReviewPlaceNo(reviewPlaceNo));

        return reviewList;
    }
}
