package com.ohgiraffers.adregamdi.review.domain.aggregate.entity;

import java.util.Date;

public class Review {

    private int reviewNo;   // 기본 키
    private int likeNum;
    private int starPoint;
    private String reviewImage;
    private String reviewContents;
    private Date regDate;
    private ReviewWriterNo reviewWriterNo;
    private ReviewPlaceNo reviewPlaceNo;
}