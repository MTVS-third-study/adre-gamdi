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

                String root = "C:\\app-file";
                String filePath = root + "/uploadFiles";

                File dir = new File(filePath);
                if (!dir.exists()) {
                        dir.mkdirs();
                }

                String originFileName = imageFile.getOriginalFilename();
                System.out.println("originFileName = " + originFileName);
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                System.out.println("ext = " + ext);
                String savedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;
                System.out.println("savedName = " + savedName);

                try {
                        imageFile.transferTo(new File(filePath + "/" + savedName));
                } catch (IOException e) {
                        new File(filePath + "/" + savedName).delete();
                }

                reviewService.insertReview(reviewDTO);
                return "placeReviews";
        }
}
