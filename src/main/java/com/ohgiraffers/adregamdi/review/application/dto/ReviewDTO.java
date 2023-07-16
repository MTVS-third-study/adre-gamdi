package com.ohgiraffers.adregamdi.review.application.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDTO {

    private int reviewNo;   // 기본 키
    private int likeNum;
    private int starPoint;
    private String originReviewImageName;
    private String savedReviewImageName;
    private String reviewContent;
    private Timestamp regDate;
//    private ReviewWriterNo reviewWriterNo;
//    private ReviewPlaceNo reviewPlaceNo;
}