package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.application.service.ReviewService;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.ReviewWriterNo;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

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
    public String registReview(HttpSession session,ReviewDTO reviewDTO, @RequestParam MultipartFile imageFile,
                               HttpServletResponse response, Model model) throws IOException {
        User user = (User) session.getAttribute("user");
        reviewDTO.setReviewWriterNo(new ReviewWriterNo(user.getUserNo()));
        reviewService.insertReview(reviewDTO)
        if (reviewService.insertReview(reviewDTO, imageFile, model)) {
            reviewService.alert("리뷰가 등록되었습니다.", response);

            return "placeReviews";

        } else {
            reviewService.alert("리뷰 등록에 실패하였습니다.", response);

            return "registReview";
        }
    }
}
