package com.ohgiraffers.adregamdi.review.domain.entity;

public class reviewEntity {

    private int reviewNo;
    private int likeNum;
    private int starpoint;
    private String image;
    private String reviewContents;
    private int reportedNum;
    private int userNo;
    private int placeNo;

    public reviewEntity(int reviewNo, int likeNum, int starpoint, String image, String reviewContents, int reportedNum, int userNo, int placeNo) {
        this.reviewNo = reviewNo;
        this.likeNum = likeNum;
        this.starpoint = starpoint;
        this.image = image;
        this.reviewContents = reviewContents;
        this.reportedNum = reportedNum;
        this.userNo = userNo;
        this.placeNo = placeNo;
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

    public int getStarpoint() {
        return starpoint;
    }

    public void setStarpoint(int starpoint) {
        this.starpoint = starpoint;
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

    public int getReportedNum() {
        return reportedNum;
    }

    public void setReportedNum(int reportedNum) {
        this.reportedNum = reportedNum;
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
