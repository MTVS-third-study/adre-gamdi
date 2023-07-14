package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ReviewController {

        private ReviewService reviewService;

        @Autowired
        public ReviewController(ReviewService reviewService) {
                this.reviewService = reviewService;
        }

        @GetMapping("placeReviews")
        public String placeReviewsPage() {
                return "placeReviews";
        }
        @GetMapping("registReview")
        public String registReviewPage() {
                return "registReview";
        }

        @PostMapping("registReview")
        public String registReview(ReviewDTO reviewDTO, @RequestParam MultipartFile imageFile) {

                reviewService.insertReview(reviewDTO, imageFile);

                return "placeReviews";
        }
}
