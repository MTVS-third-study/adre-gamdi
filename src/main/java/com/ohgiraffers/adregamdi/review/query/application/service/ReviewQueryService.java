package com.ohgiraffers.adregamdi.review.query.application.service;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.query.infra.repository.ReviewQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewQueryService {

    private final ReviewQueryRepository reviewQueryRepository;

    @Autowired
    public ReviewQueryService(ReviewQueryRepository reviewQueryRepository) {
        this.reviewQueryRepository = reviewQueryRepository;
    }

//    public List<ReviewDTO> getReviewList(Long reviewPlaceNo) {
//        List<Review> reviewList = reviewQueryRepository.findALLByReviewPlaceNo(new ReviewPlaceNo(reviewPlaceNo));
//        List<ReviewDTO> reviewDTOList = new ArrayList<>();
//
//        for(Review review : reviewList) {
//            ReviewDTO reviewDTO = new ReviewDTO();
//            reviewDTO.setReviewNo(review.getReviewNo());
//            reviewDTO.setOriginReviewImageName(review.getOriginReviewImageName());
//            reviewDTO.setSavedReviewImageName(review.getSavedReviewImageName());
//            reviewDTO.setImageFilePath(review.getImageFilePath());
//            reviewDTO.setReviewContent(review.getReviewContent());
//            reviewDTO.setRegDate(review.getRegDate());
//            reviewDTO.setReviewWriter(review.getReviewWriter());
//            reviewDTO.setReviewPlaceNo(review.getReviewPlaceNo());
//
//            reviewDTOList.add(reviewDTO);
//        }
//        return reviewDTOList;
//    }

    public List<ReviewDTO> getReviewList(Long placeNo) {
        List<Review> reviewList = reviewQueryRepository.findALLByReviewPlaceNo(new ReviewPlaceNo(placeNo));
        List<ReviewDTO> reviewDTOList = new ArrayList<>();

        for (Review review : reviewList) {
            System.out.println("review = " + review);

            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setReviewNo(review.getReviewNo());
            reviewDTO.setOriginReviewImageName(review.getOriginReviewImageName());
            reviewDTO.setSavedReviewImageName(review.getSavedReviewImageName());
            reviewDTO.setImageFilePath(review.getImageFilePath());
            reviewDTO.setReviewContent(review.getReviewContent());
            reviewDTO.setRegDate(review.getRegDate());
            reviewDTO.setReviewWriter(review.getReviewWriter());
            reviewDTO.setReviewPlaceNo(review.getReviewPlaceNo());
            reviewDTO.setStarPoint(review.getStarPoint());
            reviewDTO.setLikeNum(review.getLikeNum());

            reviewDTOList.add(reviewDTO);
        }
        return reviewDTOList;
    }
}
