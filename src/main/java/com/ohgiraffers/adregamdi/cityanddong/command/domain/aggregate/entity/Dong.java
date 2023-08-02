package com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Entity
@Table(name = "TBL_DONG")
public class Dong {

    @Id
    @Column(name = "DONG_NO")
    private int dongNo;

    @Column(name = "DONG_NAME",unique = true)
    private String dongName;
}
