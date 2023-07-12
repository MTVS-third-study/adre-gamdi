package com.ohgiraffers.adregamdi.review.application.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewDTO {
    private int reviewNo;
    private int likeNum;
    private double starPoint;
    private String reviewImage;
    private String reviewContents;
    private boolean reportStatus;
    private int userNo;
    private int placeNo;
    private Date regDate;
}
