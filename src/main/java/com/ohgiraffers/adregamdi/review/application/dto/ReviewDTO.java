package com.ohgiraffers.adregamdi.review.application.dto;

import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.domain.aggregate.entity.ReviewWriterNo;
import lombok.*;

import java.util.Date;

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
    private Date regDate;
    private ReviewWriterNo reviewWriterNo;
    private ReviewPlaceNo reviewPlaceNo;
}
