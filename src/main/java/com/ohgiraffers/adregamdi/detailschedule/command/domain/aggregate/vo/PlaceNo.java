package com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Embeddable
public class PlaceNo implements Serializable {

    @Column
    private Long placeNo;

    protected PlaceNo() {
    }

    public PlaceNo(Long placeNo) {
        this.placeNo = placeNo;
    }
}
