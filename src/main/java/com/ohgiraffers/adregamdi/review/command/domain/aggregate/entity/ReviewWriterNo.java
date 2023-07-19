package com.ohgiraffers.adregamdi.review.command.domain.aggregate.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ReviewWriterNo implements Serializable {

    @Column(name = "user_no")
    private Long reviewWriterNo;

    protected ReviewWriterNo(){};
    public ReviewWriterNo(Long reviewWriterNo) {
    this.reviewWriterNo = reviewWriterNo;
}
}
