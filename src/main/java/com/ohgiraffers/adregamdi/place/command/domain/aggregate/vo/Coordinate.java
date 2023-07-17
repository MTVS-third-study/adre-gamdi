package com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo;

import lombok.EqualsAndHashCode;
import javax.persistence.Embeddable;

@Embeddable
@EqualsAndHashCode
public class Coordinate {

    private double latitude;
    private double longitude;
}
