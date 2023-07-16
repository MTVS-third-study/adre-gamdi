package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "TBL_PLACE")
public class Place {

    @Id
    @Column(name = "PLACE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeNo;
    @Column(nullable = false, name = "PLACE_NAME")
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
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Embedded
    private CoordinateVO coordinateVO;
    @Embedded
    private AddressVO addressVO;

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
