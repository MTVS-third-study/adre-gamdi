package com.ohgiraffers.adregamdi.place.query.application.dto;

public class PlaceDTO {
    private Long placeNo;
    private String placeName;
    private String categoryName;
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

    public PlaceDTO() {
    }

    public PlaceDTO(Long placeNo, String placeName, String categoryName, int cityNo,
                    int dongNo, String introduction, String phoneNumber, double latitude,
                    double longitude, String postCode, String placeAddress, String roadPlaceAddress,
                    String imagePath, String thumbnailPath, double averageStarPoint, int reviewCount) {
        this.placeNo = placeNo;
        this.placeName = placeName;
        this.categoryName = categoryName;
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

    public void setPlaceNo(Long placeNo) {
        this.placeNo = placeNo;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCityNo() {
        return cityNo;
    }

    public void setCityNo(int cityNo) {
        this.cityNo = cityNo;
    }

    public int getDongNo() {
        return dongNo;
    }

    public void setDongNo(int dongNo) {
        this.dongNo = dongNo;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPlaceAddress() {
        return placeAddress;
    }

    public void setPlaceAddress(String placeAddress) {
        this.placeAddress = placeAddress;
    }

    public String getRoadPlaceAddress() {
        return roadPlaceAddress;
    }

    public void setRoadPlaceAddress(String roadPlaceAddress) {
        this.roadPlaceAddress = roadPlaceAddress;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public double getAverageStarPoint() {
        return averageStarPoint;
    }

    public void setAverageStarPoint(double averageStarPoint) {
        this.averageStarPoint = averageStarPoint;
    }

    public int getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(int reviewCount) {
        this.reviewCount = reviewCount;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "placeNo=" + placeNo +
                ", placeName='" + placeName + '\'' +
                ", categoryName='" + categoryName + '\'' +
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
