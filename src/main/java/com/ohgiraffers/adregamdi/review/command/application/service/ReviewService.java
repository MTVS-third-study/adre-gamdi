package com.ohgiraffers.adregamdi.review.command.application.service;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewWriter;
import com.ohgiraffers.adregamdi.review.command.domain.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public boolean insertReview(ReviewDTO reviewDTO, MultipartFile imageFile, Model model,
                                Long userNo, String userName, Long placeNo) {

        if (insertReviewImage(reviewDTO, imageFile) && isNotNull(reviewDTO, model)) {

            ReviewWriter reviewWriter = new ReviewWriter(userNo, userName);
            ReviewPlaceNo reviewPlaceNo = new ReviewPlaceNo(placeNo);

            Review review = new Review(reviewDTO.getReviewNo(), reviewDTO.getLikeNum(), reviewDTO.getStarPoint(),
                    reviewDTO.getOriginReviewImageName(), reviewDTO.getSavedReviewImageName(),
                    reviewDTO.getImageFilePath(), reviewDTO.getReviewContent(), reviewDTO.getRegDate(), reviewWriter, reviewPlaceNo);

            reviewRepository.save(review);
            return true;
        }

        return false;
    }


    private boolean insertReviewImage(ReviewDTO reviewDTO, MultipartFile imageFile) {

        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/images/reviewImages/"; //user.dir은 프로젝트 경로

        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();   //폴더 없을 시 자동으로 하위폴더 생성
        }

        String originFileName = imageFile.getOriginalFilename();  //원본 파일 이름
        String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1); //파일 확장자
        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext; //저장되는 이름

        try {
            if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
                return false;
            }

            imageFile.transferTo(new File(filePath + savedName));
            reviewDTO.setOriginReviewImageName(originFileName);
            reviewDTO.setSavedReviewImageName(savedName);
            reviewDTO.setImageFilePath(filePath);

        } catch (IOException e) {
            new File(filePath + savedName).delete();  //업로드 후 DB저장 중 오류났을 때 업로드된 이미지 삭제해줌

        }
        return true;
    }


    private boolean isNotNull(ReviewDTO reviewDTO, Model model) {
        if (!reviewDTO.getReviewContent().equals("") && reviewDTO.getStarPoint() != 0
                && reviewDTO.getOriginReviewImageName() != null) {
            return true;
        }

        if (reviewDTO.getReviewContent().equals("")) {
            model.addAttribute("nullContent", "리뷰 내용은 필수 입력값입니다.");
        }

        if (reviewDTO.getStarPoint() == 0) {
            model.addAttribute("nullStarPoint", "별점을 선택해주세요");
        }

        if (reviewDTO.getOriginReviewImageName() == null) {

            model.addAttribute("incorrectExtension", "jpg, jpeg, png형식의 이미지 파일을 올려주세요.");
        }

        return false;
    }

//    public boolean insertReview(ReviewDTO reviewDTO, MultipartFile imageFile, Model model,
//                                Long userNo, String userName, Long placeNo) {
//
//        if (insertReviewImage(reviewDTO, imageFile) && isNotNull(reviewDTO, model)) {
//
//            ReviewWriter reviewWriter = new ReviewWriter(userNo, userName);
//            ReviewPlaceNo reviewPlaceNo = new ReviewPlaceNo(placeNo);
//
//            Review review = new Review(reviewDTO.getReviewNo(), reviewDTO.getLikeNum(), reviewDTO.getStarPoint(),
//                    reviewDTO.getOriginReviewImageName(), reviewDTO.getSavedReviewImageName(),
//                    reviewDTO.getImageFilePath(), reviewDTO.getReviewContent(), reviewDTO.getRegDate(), reviewWriter, reviewPlaceNo);
//
//            reviewRepository.save(review);
//            return true;
//        }
//
//        return false;
//    }
//
//    public void updateReview(@PathVariable("reviewNo") Review review) {
//        reviewRepository.save(review);
//    }
//
//    public void deleteReview(int reviewNo) {
//        reviewRepository.deleteById(reviewNo);
//    }
//
//    private boolean insertReviewImage(ReviewDTO reviewDTO, MultipartFile imageFile) {
//
//        String filePath = System.getProperty("user.dir") + "/src/main/resources/static/images/reviewImages/"; //user.dir은 프로젝트 경로
//
//        File dir = new File(filePath);
//        if (!dir.exists()) {
//            dir.mkdirs();   //폴더 없을 시 자동으로 하위폴더 생성
//        }
//
//        String originFileName = imageFile.getOriginalFilename();  //원본 파일 이름
//        String ext = originFileName.substring(originFileName.lastIndexOf(".") + 1); //파일 확장자
//        String savedName = UUID.randomUUID().toString().replaceAll("-", "") + "." + ext; //저장되는 이름
//
//        try {
//            if (!ext.equals("jpg") && !ext.equals("jpeg") && !ext.equals("png")) {
//                return false;
//            }
//
//            imageFile.transferTo(new File(filePath + savedName));
//            reviewDTO.setOriginReviewImageName(originFileName);
//            reviewDTO.setSavedReviewImageName(savedName);
//            reviewDTO.setImageFilePath(filePath);
//
//        } catch (IOException e) {
//            new File(filePath + savedName).delete();  //업로드 후 DB저장 중 오류났을 때 업로드된 이미지 삭제해줌
//
//        }
//        return true;
//    }
//
//
//    private boolean isNotNull(ReviewDTO reviewDTO, Model model) {
//        if (!reviewDTO.getReviewContent().equals("") && reviewDTO.getStarPoint() != 0
//                && reviewDTO.getOriginReviewImageName() != null) {
//            return true;
//        }
//
//        if (reviewDTO.getReviewContent().equals("")) {
//            model.addAttribute("nullContent", "리뷰 내용은 필수 입력값입니다.");
//        }
//
//        if (reviewDTO.getStarPoint() == 0) {
//            model.addAttribute("nullStarPoint", "별점을 선택해주세요");
//        }
//
//        if (reviewDTO.getOriginReviewImageName() == null) {
//
//            model.addAttribute("incorrectExtension", "jpg, jpeg, png형식의 이미지 파일을 올려주세요.");
//        }
//
//        return false;
//    }


}
