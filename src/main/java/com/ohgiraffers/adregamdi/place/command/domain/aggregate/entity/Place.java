package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;


//@Entity
//@Table(name= "TBL_PLACE")

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Address;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Coordinate;

public class Place {

//    @Id
//    @Column(name = "PLACE_NO")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeNo;
    private String placeName;

    private Coordinate coordinate;
//    private double latitude;
//    private double longitude;

    private String phoneNumber;
    private String categoryCode;

    private Address address;
//    private String placeAddress;
//    private String roadPlaceAddress;

    private double averageStarPoint;
    private int reviewCount;

}
