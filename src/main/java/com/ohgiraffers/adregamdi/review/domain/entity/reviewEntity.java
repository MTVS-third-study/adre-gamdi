package com.ohgiraffers.adregamdi.review.domain.entity;

import java.util.Date;

public class reviewEntity {

    private int reviewNo;
    private int likeNum;
    private int starPoint;
    private String image;
    private String reviewContents;
    private boolean reportStatus;
    private int userNo;
    private int placeNo;
    private Date regDate;


    public reviewEntity() {
    }

    public reviewEntity(int reviewNo, int likeNum, int starPoint, String image, String reviewContents, boolean reportStatus, int userNo, int placeNo, Date regDate) {
        this.reviewNo = reviewNo;
        this.likeNum = likeNum;
        this.starPoint = starPoint;
        this.image = image;
        this.reviewContents = reviewContents;
        this.reportStatus = reportStatus;
        this.userNo = userNo;
        this.placeNo = placeNo;
        this.regDate = regDate;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public void setReviewNo(int reviewNo) {
        this.reviewNo = reviewNo;
    }

    public int getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(int likeNum) {
        this.likeNum = likeNum;
    }

    public int getStarPoint() {
        return starPoint;
    }

    public void setStarPoint(int starPoint) {
        this.starPoint = starPoint;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getReviewContents() {
        return reviewContents;
    }

    public void setReviewContents(String reviewContents) {
        this.reviewContents = reviewContents;
    }

    public boolean getReportedNum() {
        return reportStatus;
    }

    public void reportStatus(boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    public int getUserNo() {
        return userNo;
    }

    public void setUserNo(int userNo) {
        this.userNo = userNo;
    }

    public int getPlaceNo() {
        return placeNo;
    }

    public void setPlaceNo(int placeNo) {
        this.placeNo = placeNo;
    }


}
