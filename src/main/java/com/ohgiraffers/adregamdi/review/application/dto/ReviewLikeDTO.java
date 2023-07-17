package com.ohgiraffers.adregamdi.review.application.dto;


import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.Review;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewLikeDTO {

    private int reviewLikeNo;
    private Review likedReviewNo;
    private User likeReviewUserNo;
}
