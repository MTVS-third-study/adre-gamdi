package com.ohgiraffers.adregamdi.review.query.infra.repository;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity.ReviewPlaceNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReviewQueryRepository extends JpaRepository<Review, Integer> {

    List<Review> findByReviewPlaceNo(ReviewPlaceNo placeNo);
}
