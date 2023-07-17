package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.*;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@ToString
@Table(name= "TBL_PLACE")
public class Place {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeNo;
    @Column(nullable = false)
    private String placeName;

    /* 지역 분류 */
    @Embedded
    private CategoryVO categoryVO;
    @Embedded
    private CityVO cityVO;
    @Embedded
    private DongVO dongVO;

    /* 가게 정보 */
    private String introduction;
    @Column
    private String phoneNumber;
    @Embedded
    private CoordinateVO coordinateVO;
    @Column
    private String postCode;
    @Column
    private String placeAddress;
    @Column
    private String roadPlaceAddress;


    /* 이미지 관련 */
    @Column
    private String imagePath;
    @Column
    private String thumbnailPath;

    /* 별점, 리뷰 */
    @Column
    private double averageStarPoint;
    @Column
    private int reviewCount;

    public Place(String placeName, CategoryVO categoryVO, CityVO cityVO, DongVO dongVO, String introduction, String phoneNumber, CoordinateVO coordinateVO, String postCode, String placeAddress, String roadPlaceAddress, String imagePath, String thumbnailPath, double averageStarPoint, int reviewCount) {
        this.placeName = placeName;
        this.categoryVO = categoryVO;
        this.cityVO = cityVO;
        this.dongVO = dongVO;
        this.introduction = introduction;
        this.phoneNumber = phoneNumber;
        this.coordinateVO = coordinateVO;
        this.postCode = postCode;
        this.placeAddress = placeAddress;
        this.roadPlaceAddress = roadPlaceAddress;
        this.imagePath = imagePath;
        this.thumbnailPath = thumbnailPath;
        this.averageStarPoint = averageStarPoint;
        this.reviewCount = reviewCount;
    }
}
