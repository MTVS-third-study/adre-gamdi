package com.ohgiraffers.adregamdi.report.domain.entity;

import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportEntity {

    private int reportNo;
    private int reportCategoryCode;
    private String reportContents;
    private Date reportedDate;
    private reporterNo reporterNo;
    private respondentNo respondentNo;
}