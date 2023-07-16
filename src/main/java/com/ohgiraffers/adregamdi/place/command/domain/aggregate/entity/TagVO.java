package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class TagVO {

    @Column(nullable = false, name = "tag_no")
    private Long tagNo;
}
