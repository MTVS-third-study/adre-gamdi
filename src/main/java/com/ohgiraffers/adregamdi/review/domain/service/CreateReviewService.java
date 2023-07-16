package com.ohgiraffers.adregamdi.review.domain.service;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CreateReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public CreateReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(ReviewDTO reviewDTO) {

        Review review = new Review(reviewDTO.getReviewNo(), reviewDTO.getLikeNum(), reviewDTO.getStarPoint(),
                reviewDTO.getOriginReviewImageName(), reviewDTO.getSavedReviewImageName(),
                reviewDTO.getReviewContent(), reviewDTO.getRegDate());

        reviewRepository.save(review);

    }

    public boolean insertReviewImage(ReviewDTO reviewDTO, MultipartFile imageFile) {

        String root = "C:\\app-file";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originFileName = imageFile.getOriginalFilename();  //원본 파일 이름
        String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1); //파일 확장자
        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext;
        if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
            return false;
        }
        try {
            imageFile.transferTo(new File(filePath + "/" + savedName));
            reviewDTO.setOriginReviewImageName(originFileName);
            reviewDTO.setSavedReviewImageName(savedName);
        } catch (IOException e) {
            new File(filePath + "/" + savedName).delete();
        }
        return true;
    }

    public boolean isNotNull(ReviewDTO reviewDTO, MultipartFile imageFile, Model model) {
        if (!reviewDTO.getReviewContent().equals("") && reviewDTO.getStarPoint() != 0 && insertReviewImage(reviewDTO, imageFile)) {
            return true;
        }

        if (reviewDTO.getReviewContent().equals("")) {
            model.addAttribute("nullContent", "리뷰 내용은 필수 입력값입니다.");
        }

        if (reviewDTO.getStarPoint() == 0) {
            model.addAttribute("nullStarPoint", "별점을 선택해주세요");
        }

        if (!insertReviewImage(reviewDTO, imageFile)) {
            model.addAttribute("incorrectExtension", "jpg, jpeg, png형식의 이미지 파일을 올려주세요.");
        }

        return false;
    }
}