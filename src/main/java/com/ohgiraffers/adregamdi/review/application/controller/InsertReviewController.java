package com.ohgiraffers.adregamdi.review.application.controller;

import com.ohgiraffers.adregamdi.review.domain.service.InsertReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class InsertReviewController {

        private InsertReviewService insertReviewService;

        @Autowired
        public InsertReviewController(InsertReviewService insertReviewService) {
                this.insertReviewService = insertReviewService;
        }


}
