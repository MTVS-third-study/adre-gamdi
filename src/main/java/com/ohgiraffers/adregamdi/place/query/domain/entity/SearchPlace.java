package com.ohgiraffers.adregamdi.place.query.domain.entity;


public class SearchPlace {

    private Long placeNo;
    private String placeName;
    private String placeAddress;
    private String roadPlaceAddress;

    public SearchPlace() {
    }

    public SearchPlace(Long placeNo, String placeName, String placeAddress, String roadPlaceAddress) {
        this.placeNo = placeNo;
        this.placeName = placeName;
        this.placeAddress = placeAddress;
        this.roadPlaceAddress = roadPlaceAddress;
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

    @Override
    public String toString() {
        return "SearchPlace{" +
                "placeNo=" + placeNo +
                ", placeName='" + placeName + '\'' +
                ", placeAddress='" + placeAddress + '\'' +
                ", roadPlaceAddress='" + roadPlaceAddress + '\'' +
                '}';
    }
}
