package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.application.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/*")
public class ReviewController {

    private final ReviewService reviewService;

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
    public String registReview(ReviewDTO reviewDTO, @RequestParam MultipartFile imageFile,
                               HttpServletResponse response, Model model) throws IOException {

        if (reviewService.insertReview(reviewDTO, imageFile, model)) {
            reviewService.alert("리뷰가 등록되었습니다.", response);
            return "placeReviews";

        } else {
            reviewService.alert("다시작성.", response);
            return "registReview";
        }
    }
}