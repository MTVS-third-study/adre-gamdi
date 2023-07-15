package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Address;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Coordinate;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name= "TBL_PLACE")
public class Place {

    @Id
    @Column(name = "PLACE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeNo;
    @Column(nullable = false, name = "PLACE_NAME")
    private String placeName;

    /* 지역 분류 */
    @Column(nullable = false, name = "CATEGORY_NO")
    private int categoryNo;
    @Column(name = "CITY_NO")
    private int cityNo;
    @Column(name = "DONG_NO")
    private int dongNo;

    /* 가게 정보 */
    @Column(name = "INTRODUCTION")
    private String introduction;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Embedded
    private Coordinate coordinate;
    @Embedded
    private Address address;

    /* 이미지 관련 */
    @Column(name = "IMAGE_PATH")
    private String imagePath;
    @Column(name = "THUMBNAIL_PATH")
    private String thumbnailPath;

    /* 별점, 리뷰 */
    @Column(name = "AVERAGE_STARPOINT")
    private double averageStarPoint;
    @Column(name = "REVIEW_COUNT")
    private int reviewCount;

}
