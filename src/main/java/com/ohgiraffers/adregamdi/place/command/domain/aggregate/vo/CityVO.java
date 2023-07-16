package com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class CityVO {

    @Column(nullable = false, name = "CITY_NO")
    private Long cityNo;

}
