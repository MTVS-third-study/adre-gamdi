package com.ohgiraffers.adregamdi.review.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReviewEntity {

    private int reviewNo;
    private int likeNum;
    private double starPoint;
    private String reviewImage;
    private String reviewContents;
    private boolean reportStatus;
    private Date regDate;
    private reviewWriterNo reviewWriterNo;
    private reviewPlaceNo reviewPlaceNo;
}