package com.ohgiraffers.adregamdi.report.command.application.dto;

import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportedReview;
import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportUserNo;
import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportedUserNo;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReportDTO {

    private Long reportNo;   // pk
    private int reportCategoryCode;
    private String reportContents;
    private Timestamp reportedDate;
    private ReportUserNo reportUserNo;  // 신고자
    private ReportedUserNo reportedUserNo; // 피신고자
    private ReportedReview reportedReview;
}
