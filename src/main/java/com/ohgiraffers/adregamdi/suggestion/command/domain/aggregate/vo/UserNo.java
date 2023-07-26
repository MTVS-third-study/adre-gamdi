package com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo;


import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserNo {

    @Column(name = "user_no")
    private Long userNo;

    protected UserNo(){}

    public UserNo(Long userNo){
        this.userNo = userNo;
    }
}
