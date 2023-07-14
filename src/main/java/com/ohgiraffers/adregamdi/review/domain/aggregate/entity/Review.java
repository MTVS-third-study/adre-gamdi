package com.ohgiraffers.adregamdi.review.domain.aggregate.entity;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Review {

    private int reviewNo;   // 기본 키
    private int likeNum;
    private int starPoint;
    private String originReviewImageName;
    private String savedReviewImageName;
    private String reviewContent;
    private Date regDate;
    private ReviewWriterNo reviewWriterNo;
    private ReviewPlaceNo reviewPlaceNo;
}