package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.PlaceVO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.TagVO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_PLACETAGS")
public class PlaceTags {

    @Id
    @Column(name = "place_tags_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long placeTagsNo;

    @Embedded
    private PlaceVO placeVO;

    @Embedded
    private TagVO tagVO;

}
