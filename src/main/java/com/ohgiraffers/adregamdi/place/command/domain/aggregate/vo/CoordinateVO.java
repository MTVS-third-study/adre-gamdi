package com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@EqualsAndHashCode
@Embeddable
public class CoordinateVO {

    @Column(name = "LATITUDE")
    private double latitude;
    @Column(name = "LONGITUDE")
    private double longitude;

    public CoordinateVO(double latitude, double longitude) {

        if (latitude >= 32 && latitude <= 35){
            this.latitude = latitude;
        } else {
            this.latitude = 0;
        }

        if (longitude >= 124 && longitude <= 128){
            this.longitude = longitude;
        } else {
            this.longitude = 0;
        }
    }
}