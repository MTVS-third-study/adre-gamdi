package com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "TBL_CITY")
public class City {

    @Id
    @Column(name = "CITY_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cityNo;

    @Column(name = "CITY_NAME", unique = true)
    private String cityName;

    public City(String cityName) {
        this.cityName = cityName;
    }
}
