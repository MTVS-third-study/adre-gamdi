package com.ohgiraffers.adregamdi.report.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportUserNo;
import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportedReview;
import com.ohgiraffers.adregamdi.report.command.domain.aggregate.vo.ReportedUserNo;
import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
@Entity
@Table(name = "TBL_REPORT")
public class Report {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;   // pk
    @Column
    private int reportCategoryCode;
    @Column
    private String reportContents;
    @Column(name = "REG_DATE", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp reportedDate;
    @Embedded
    private ReportUserNo reportUserNo;  // 신고자
    @Embedded
    private ReportedUserNo reportedUserNo; // 피신고자
    @Embedded
    private ReportedReview reportedReview;
}