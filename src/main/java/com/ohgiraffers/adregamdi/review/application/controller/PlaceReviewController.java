package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class PlaceReviewController {

    private ReviewRepository reviewRepository;

    public PlaceReviewController(ReviewRepository reviewRepository) {}

    @GetMapping("{userNo}")
    public String placeReviewsPage(@PathVariable int reviewNo, Model model, HttpSession httpSession) {
        Optional<Review> reviewDTO = reviewRepository.findById(reviewNo);


        return "placeReviews";
    }

    }

