package com.ohgiraffers.adregamdi.review.query.application.service;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.query.infra.repository.ReviewQueryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@SpringBootTest
public class ReviewQueryServiceTests {

    @Autowired
    private ReviewQueryRepository reviewQueryRepository;

    @DisplayName("장소별 리뷰 조회 테스트")
    @Test
    void findAllReviewByPlaceNo(Long reviewPlaceNo) {
        reviewPlaceNo = 20L;
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

            reviewDTOList.add(new reviewDTO);
        }
        reviewDTOList.forEach(System.out::println);

        Assertions.assertNotNull(reviewDTOList);
    }



    @DisplayName("맵으로 장소 조회 테스트")
    @Test
    void reviewInfo() {

        List<Review> reviewList = reviewQueryRepository.findAllByReviewPlaceNo(new ReviewPlaceNo(20L));

        Map<String, List<Review>> reviewMap = new HashMap<>();
        reviewMap.put("reviewList", reviewList);

        Collection<List<Review>> reviewLists = reviewMap.values();
        Iterator<List<Review>> iterator = reviewLists.iterator();

        while (iterator.hasNext()) {
            System.out.println("value : " + iterator.next());
        }

        Assertions.assertNotNull(reviewMap);
    }
}
