package com.ohgiraffers.adregamdi.report.domain.entity;

import java.util.Date;

public class reportEntity {

    private int reportNo;
    private int reporterNo;
    private int respondentNo;
    private int reportedReviewNo;
    private String reportContents;
    private Date reportedDate;

    public reportEntity(int reportNo, int reporterNo, int respondentNo, int reportedReviewNo, String reportContents, Date reportedDate) {
        this.reportNo = reportNo;
        this.reporterNo = reporterNo;
        this.respondentNo = respondentNo;
        this.reportedReviewNo = reportedReviewNo;
        this.reportContents = reportContents;
        this.reportedDate = reportedDate;
    }

    public int getReportNo() {
        return reportNo;
    }

    public void setReportNo(int reportNo) {
        this.reportNo = reportNo;
    }

    public int getReporterNo() {
        return reporterNo;
    }

    public void setReporterNo(int reporterNo) {
        this.reporterNo = reporterNo;
    }

    public int getRespondentNo() {
        return respondentNo;
    }

    public void setRespondentNo(int respondentNo) {
        this.respondentNo = respondentNo;
    }

    public int getReportedReviewNo() {
        return reportedReviewNo;
    }

    public void setReportedReviewNo(int reportedReviewNo) {
        this.reportedReviewNo = reportedReviewNo;
    }

    public String getReportContents() {
        return reportContents;
    }

    public void setReportContents(String reportContents) {
        this.reportContents = reportContents;
    }

    public Date getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(Date reportedDate) {
        this.reportedDate = reportedDate;
    }
}
