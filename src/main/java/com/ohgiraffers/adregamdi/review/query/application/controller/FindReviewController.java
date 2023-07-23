package com.ohgiraffers.adregamdi.review.query.application.controller;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.query.application.service.FindReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/review/query")
public class FindReviewController {

    private FindReviewService findReviewService;

    @Autowired
    public FindReviewController(FindReviewService findReviewService) {
        this.findReviewService = findReviewService;
    }


    @GetMapping("/reviewList")
    public String goReviewListPage(Model model, Long reviewPlaceNo) {
        reviewPlaceNo = 20L;
        List<Review> reviews = findReviewService.getReviewList(reviewPlaceNo);

        model.addAttribute("reviews", reviews);

        return "schedule";

    }
}
