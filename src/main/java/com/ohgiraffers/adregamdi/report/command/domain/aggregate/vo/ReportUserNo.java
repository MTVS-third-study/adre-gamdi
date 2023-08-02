package com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
public class ReportUserNo {

    @Column
    private Long reportUserNo;

    protected ReportUserNo() {}

    public ReportUserNo(Long reportUserNo) {
        this.reportUserNo = reportUserNo;
    }
}
