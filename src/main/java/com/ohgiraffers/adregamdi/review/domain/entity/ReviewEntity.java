package com.ohgiraffers.adregamdi.review.domain.entity;

import lombok.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "REVIEW_TBL")
public class ReviewEntity {

    @Id
    private int reviewNo;
    @Column
    private int likeNum;
    @Column
    private double starPoint;
    @Column
    private String reviewImage;
    @Column
    private String reviewContents;
    @Column
    private boolean reportStatus;
    private int userNo;
    private int placeNo;
    private Date regDate;
}