package com.ohgiraffers.adregamdi.report.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.report.domain.aggregate.vo.ReportUserNo;
import com.ohgiraffers.adregamdi.report.domain.aggregate.vo.RespondentNo;
import lombok.*;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Report {

    private int reportNo;   // pk
    private int reportCategoryCode;
    private String reportContents;
    private Date reportedDate;
    private ReportUserNo reportUserNo;  // 신고자
    private RespondentNo respondentNo; // 피신고자
    private ReportedReview reportedReview;
}