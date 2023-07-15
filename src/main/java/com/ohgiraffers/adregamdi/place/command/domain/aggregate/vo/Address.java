package com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "PLACE_ADDRESS")
    private String placeAddress;
    @Column(name = "ROAD_PLACE_ADDRESS")
    private String roadPlaceAddress;

}
