package com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewPlaceNo;
import com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo.ReviewWriter;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Table(name = "TBL_REVIEW")
public class Review {

    @Id
    @Column(name = "REVIEW_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;   // 기본 키
    @Column
    private int likeNum;
    @Column
    private int starPoint;
    @Column
    private String originReviewImageName;
    @Column
    private String savedReviewImageName;
    @Column
    private String imageFilePath;
    @Column
    private String reviewContent;
    @Column(name = "REG_DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp regDate;
    @Embedded
    private ReviewWriter reviewWriter;
    @Embedded
    private ReviewPlaceNo reviewPlaceNo;

}