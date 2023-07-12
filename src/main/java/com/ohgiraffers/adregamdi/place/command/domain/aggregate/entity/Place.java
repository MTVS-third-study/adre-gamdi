package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


public class Place {
    private int placeNumber;
    private String placeName;
    private double latitude;
    private double longitude;
    private String phoneNumber;
    private String categoryCode;
    private String placeAddress;
    private String roadPlaceAddress;
}
