package com.ohgiraffers.adregamdi.review.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;

import javax.persistence.*;

@Embeddable
public class ReviewWriterNo {

    private Long reviewWriterNo;

    public ReviewWriterNo(Long userNo) {
    }

}
