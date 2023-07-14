package com.ohgiraffers.adregamdi.review.domain.service;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class CreateReviewService {

    private ReviewRepository reviewRepository;

    @Autowired
    public CreateReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public void saveReview(ReviewDTO reviewDTO) {
        reviewRepository.saveReviewInDB(reviewDTO);
    }

    public void insertReviewImage(ReviewDTO reviewDTO, MultipartFile imageFile) {

        String root = "C:\\app-file";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        String originFileName = imageFile.getOriginalFilename();
        String ext = originFileName.substring(originFileName.lastIndexOf("."));
        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + ext;

        try {
            imageFile.transferTo(new File(filePath + "/" + savedName));
        } catch (IOException e) {
            new File(filePath + "/" + savedName).delete();
        }

        reviewDTO.setOriginReviewImageName(originFileName);
        reviewDTO.setSavedReviewImageName(savedName);
    }
}
