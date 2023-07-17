package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;


//@Entity
//@Table(name= "TBL_PLACE")

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Address;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.Coordinate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "TBL_PLACE")
public class Place {

    @Id
    @Column(name = "PLACE_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int placeNo;
    @Column
    private String placeName;
    @Embedded
    private Coordinate coordinate;
    @Column
    private String phoneNumber;
    @Column
    private String categoryCode;
    @Embedded
    private Address address;
    @Column
    private double averageStarPoint;
    @Column
    private int reviewCount;

}
