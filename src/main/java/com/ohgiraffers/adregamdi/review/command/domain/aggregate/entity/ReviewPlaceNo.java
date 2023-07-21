package com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ReviewPlaceNo implements Serializable {

    @Column(name = "place_no")
    private Long reviewPlaceNo;

    protected ReviewPlaceNo() {}

    public ReviewPlaceNo(Long reviewPlaceNo) {
        this.reviewPlaceNo = reviewPlaceNo;
    }

}
