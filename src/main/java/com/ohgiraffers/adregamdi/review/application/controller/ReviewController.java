package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

        private ReviewService reviewService;

        @Autowired
        public ReviewController(ReviewService reviewService) {
                this.reviewService = reviewService;
        }

        @GetMapping("review")
        public String reviewPage() {
                return "review";
        }

        @PostMapping("review")
        public String registReview(ReviewDTO reviewDTO) {
                reviewService.insertReview();

                return "review";
        }

}
