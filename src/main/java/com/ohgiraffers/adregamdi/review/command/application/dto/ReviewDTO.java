package com.ohgiraffers.adregamdi.review.command.application.dto;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewWriter;
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
    private String imageFilePath;
    private String reviewContent;
    private Timestamp regDate;
    private ReviewWriter reviewWriter;
    private ReviewPlaceNo reviewPlaceNo;
}
