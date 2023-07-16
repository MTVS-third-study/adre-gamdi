package com.ohgiraffers.adregamdi.review.domain.repository;

import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
