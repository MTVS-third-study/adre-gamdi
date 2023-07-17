package com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo;

import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
public class Address {

    private String placeAddress;
    private String roadPlaceAddress;

}
