package com.ohgiraffers.adregamdi.place.query.domain.entity;

public class SearchPlace {

    private Long placeNo;
    private String placeName;
    private int categoryNo;
    private int cityNo;
    private int dongNo;
    private String introduction;
    private String phoneNumber;
    private double latitude;
    private double longitude;
    private String postCode;
    private String placeAddress;
    private String roadPlaceAddress;
    private String imagePath;
    private String thumbnailPath;
    private double averageStarPoint;
    private int reviewCount;

    public SearchPlace() {
    }

    public SearchPlace(Long placeNo, String placeName, int categoryNo, int cityNo, int dongNo,
                       String introduction, String phoneNumber, double latitude, double longitude,
                       String postCode, String placeAddress, String roadPlaceAddress, String imagePath,
                       String thumbnailPath, double averageStarPoint, int reviewCount) {
        this.placeNo = placeNo;
        this.placeName = placeName;
        this.categoryNo = categoryNo;
        this.cityNo = cityNo;
        this.dongNo = dongNo;
        this.introduction = introduction;
        this.phoneNumber = phoneNumber;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postCode = postCode;
        this.placeAddress = placeAddress;
        this.roadPlaceAddress = roadPlaceAddress;
        this.imagePath = imagePath;
        this.thumbnailPath = thumbnailPath;
        this.averageStarPoint = averageStarPoint;
        this.reviewCount = reviewCount;
    }

    public Long getPlaceNo() {
        return placeNo;
    }

    public String getPlaceName() {
        return placeName;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public int getCityNo() {
        return cityNo;
    }

    public int getDongNo() {
        return dongNo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getPostCode() {
        return postCode;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public String getRoadPlaceAddress() {
        return roadPlaceAddress;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public double getAverageStarPoint() {
        return averageStarPoint;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setPlaceNo(Long placeNo) {
        this.placeNo = placeNo;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public void setCityNo(int cityNo) {
        this.cityNo = cityNo;
    }

    public void setDongNo(int dongNo) {
        this.dongNo = dongNo;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public void setRoadPlaceAddress(String roadPlaceAddress) {
        this.roadPlaceAddress = roadPlaceAddress;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public void setAverageStarPoint(double averageStarPoint) {
        this.averageStarPoint = averageStarPoint;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "SearchPlace{" +
                "placeNo=" + placeNo +
                ", placeName='" + placeName + '\'' +
                ", categoryNo=" + categoryNo +
                ", cityNo=" + cityNo +
                ", dongNo=" + dongNo +
                ", introduction='" + introduction + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", postCode='" + postCode + '\'' +
                ", placeAddress='" + placeAddress + '\'' +
                ", roadPlaceAddress='" + roadPlaceAddress + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", thumbnailPath='" + thumbnailPath + '\'' +
                ", averageStarPoint=" + averageStarPoint +
                ", reviewCount=" + reviewCount +
                '}';
    }
}
