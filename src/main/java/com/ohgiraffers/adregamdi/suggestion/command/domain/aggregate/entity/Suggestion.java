package com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TBL_SUGGESTION")
public class Suggestion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestionNo;

    @Column
    private Long userNo;

    @Column
    private String suggestion;

}
