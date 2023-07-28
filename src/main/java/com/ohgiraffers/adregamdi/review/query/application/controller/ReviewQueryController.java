package com.ohgiraffers.adregamdi.review.query.application.controller;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.query.application.service.ReviewQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("/review/query")
public class ReviewQueryController {

    private final ReviewQueryService reviewQueryService;

    @Autowired
    public ReviewQueryController(ReviewQueryService reviewQueryService) {
        this.reviewQueryService = reviewQueryService;
    }


    @ResponseBody
    @GetMapping("/reviewInfo")
    public Map<String, List<ReviewDTO>> getReviewInfo(@RequestParam("placeNo") Long placeNo,
                                                Model model) {

        List<ReviewDTO> reviewList = reviewQueryService.getReviewList(placeNo);

        model.addAttribute("reviewList", reviewList);

        Map<String, List<ReviewDTO>> reviewInfo = new HashMap<>();
        reviewInfo.put("reviewInfo", reviewList);

        return reviewInfo;

    }
}
