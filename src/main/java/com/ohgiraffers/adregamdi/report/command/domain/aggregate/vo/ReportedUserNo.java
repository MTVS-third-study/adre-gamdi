package com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
public class ReportedUserNo {

    @Column
    private Long reportedUserNo;

    protected ReportedUserNo() {}

    public ReportedUserNo(Long reportedUserNo) {
        this.reportedUserNo = reportedUserNo;
    }
}
