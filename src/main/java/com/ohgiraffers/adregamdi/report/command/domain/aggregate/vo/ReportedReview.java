package com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
public class ReportedReview {

    @Column
    private int reportedReviewNo;

    protected ReportedReview() {}

    public ReportedReview(int reportedReviewNo) {
        this.reportedReviewNo = reportedReviewNo;
    }
}
