package com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PlaceNo implements Serializable {

    @Column
    private int placeNo;

    protected PlaceNo() {
    }

    public PlaceNo(int placeNo) {
        this.placeNo = placeNo;
    }
}
