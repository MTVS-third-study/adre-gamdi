package com.ohgiraffers.adregamdi.review.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@Getter
@ToString
public class ReviewWriter implements Serializable {

    @Column(name = "user_no")
    private Long reviewWriterNo;

    @Column(name = "user_nickName")
    private String reviewWriterName;

    protected ReviewWriter(){};
    public ReviewWriter(Long reviewWriterNo, String reviewWriterName) {
    this.reviewWriterNo = reviewWriterNo;
    this.reviewWriterName = reviewWriterName;

}
}
