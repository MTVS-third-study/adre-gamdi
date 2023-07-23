package com.ohgiraffers.adregamdi.review.query.application.service;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.query.infra.repository.ReviewQueryRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FindReviewServiceTests {

    @Autowired
    private ReviewQueryRepository reviewQueryRepository;

    @DisplayName("장소별 리뷰 조회 테스트")
    @Test
    void findAllReviewByPlaceNo() {
        List<Review> reviews = reviewQueryRepository.findByReviewPlaceNo(new ReviewPlaceNo(20L));

        reviews.forEach(System.out::println);


        Assertions.assertNotNull(reviews);
    }
}
