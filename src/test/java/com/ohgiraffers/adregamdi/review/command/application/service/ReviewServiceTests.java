package com.ohgiraffers.adregamdi.review.command.application.service;

import com.ohgiraffers.adregamdi.review.command.domain.repository.ReviewRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class ReviewServiceTests {

    @Autowired
    ReviewRepository reviewRepository;

//    @DisplayName("리뷰 삭제 기능 확인")
//    @ParameterizedTest
//    @ValueSource(ints = {1})
//    void deleteReview(int reviewNo) {
//
//        reviewRepository.deleteById(reviewNo);
//
//        Assertions.assertEquals(5,);
//    }

}