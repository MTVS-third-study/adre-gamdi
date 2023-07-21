package com.ohgiraffers.adregamdi.tagplace.command.domain.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class PlaceVO {

    @Column(nullable = false, name = "place_no")
    private Long placeNo;

}
