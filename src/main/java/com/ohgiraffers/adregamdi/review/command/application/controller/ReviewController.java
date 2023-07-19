package com.ohgiraffers.adregamdi.review.command.application.controller;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.application.service.ReviewService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/*")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

//    @GetMapping("placeReviews")
//    public String placeReviewsPage() {
//        return "placeReviews";
//    }

//    @GetMapping("registReview")
//    public String registReviewPage() {
//        return "registReview";
//    }


    @PostMapping("registReview")
    public String registReview(ReviewDTO reviewDTO, @RequestParam MultipartFile imageFile, UserDTO userDTO,
                               HttpServletResponse response, Model model, HttpSession session) throws IOException {
        Long placeId = 20L;
        System.out.println(session.getAttribute("loginUser"));
        System.out.println(((UserDTO) session.getAttribute("loginUser")).getUserNo());
        Long userId = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
        System.out.println("userId = " + userId);
//        Long placeId = Long.parseLong((String)session.getAttribute("placeNo"));

        if (reviewService.insertReview(reviewDTO, imageFile, model, userId, placeId)) {
            reviewService.alert("리뷰가 등록되었습니다.", response);

            return "schedule";

        } else {
            reviewService.alert("리뷰 등록에 실패하였습니다.", response);

            return "schedule";
        
        }
    }
}
