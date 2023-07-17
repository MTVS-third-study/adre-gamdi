package com.ohgiraffers.adregamdi.review.domain.service;

import com.ohgiraffers.adregamdi.review.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.ReviewWriterNo;
import com.ohgiraffers.adregamdi.review.domain.repository.ReviewRepository;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
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

    public void saveReview(ReviewDTO reviewDTO, Long userNo) {
        ReviewWriterNo reviewWriterNo = new ReviewWriterNo(userNo);

        Review review = new Review(reviewDTO.getReviewNo(), reviewDTO.getLikeNum(), reviewDTO.getStarPoint(),
                reviewDTO.getOriginReviewImageName(), reviewDTO.getSavedReviewImageName(),
                reviewDTO.getImageFilePath(), reviewDTO.getReviewContent(), reviewDTO.getRegDate(), reviewWriterNo, );

        reviewRepository.save(review);

    }

    public boolean insertReviewImage(ReviewDTO reviewDTO, MultipartFile imageFile, Model model) {

        String root = "C:\\app-file";
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();   //하위폴더 생성
        }

        String originFileName = imageFile.getOriginalFilename();  //원본 파일 이름
        String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1); //파일 확장자
        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext; //저장되는 이름
        try {
            if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
                return false;
            }

            imageFile.transferTo(new File(filePath + "/" + savedName));
            reviewDTO.setOriginReviewImageName(originFileName);
            reviewDTO.setSavedReviewImageName(savedName);
            reviewDTO.setImageFilePath(filePath);

        } catch (IOException e) {
            new File(filePath + "/" + savedName).delete();  //업로드 후 DB저장 중 오류났을 때 업로드된 이미지 삭제해줌

        }
        return true;
    }

    public boolean isNotNull(ReviewDTO reviewDTO, MultipartFile imageFile, Model model) {
        if (!reviewDTO.getReviewContent().equals("") && reviewDTO.getStarPoint() != 0 && insertReviewImage(reviewDTO, imageFile, model)) {
            return true;
        }

        if (reviewDTO.getReviewContent().equals("")) {
            model.addAttribute("nullContent", "리뷰 내용은 필수 입력값입니다.");
        }

        if (reviewDTO.getStarPoint() == 0) {
            model.addAttribute("nullStarPoint", "별점을 선택해주세요");
        }

        if (!insertReviewImage(reviewDTO, imageFile, model)) {
            model.addAttribute("incorrectExtension", "jpg, jpeg, png형식의 이미지 파일을 올려주세요.");
        }

        return false;
    }
}
