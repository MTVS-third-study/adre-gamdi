package com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@ToString
public class UserNo implements Serializable {

    @Column(name = "user_no")
    private Long userNo;

    protected UserNo(){}

    public UserNo(Long userNo){
        this.userNo = userNo;
    }

}
