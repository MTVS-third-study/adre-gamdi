package com.ohgiraffers.adregamdi.review.query.application.service;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.query.infra.repository.ReviewQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewQueryService {

    private ReviewQueryRepository reviewQueryRepository;

    @Autowired
    public ReviewQueryService(ReviewQueryRepository reviewQueryRepository) {
        this.reviewQueryRepository = reviewQueryRepository;
    }

    public List<ReviewDTO> getReviewList(Long reviewPlaceNo) {
        List<Review> reviewList = reviewQueryRepository.findAllByReviewPlaceNo(new ReviewPlaceNo(reviewPlaceNo));
        List<ReviewDTO> reviewDTOList = new ArrayList<>();
        for(Review review : reviewList) {
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setReviewNo(review.getReviewNo());
            reviewDTO.setOriginReviewImageName(review.getOriginReviewImageName());
            reviewDTO.setSavedReviewImageName(review.getSavedReviewImageName());
            reviewDTO.setImageFilePath(review.getImageFilePath());
            reviewDTO.setReviewContent(review.getReviewContent());
            reviewDTO.setRegDate(review.getRegDate());
            reviewDTO.setReviewWriter(review.getReviewWriter());
            reviewDTO.setReviewPlaceNo(review.getReviewPlaceNo());

            reviewDTOList.add(reviewDTO);
        }
        reviewDTOList.forEach(System.out::println);
        return reviewDTOList;
    }
}
