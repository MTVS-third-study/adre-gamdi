package com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TBL_DONG")
public class Dong {

    @Id
    @Column(name = "DONG_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dongNo;

    @Column(name = "DONG_NAME")
    private String dongName;
}
