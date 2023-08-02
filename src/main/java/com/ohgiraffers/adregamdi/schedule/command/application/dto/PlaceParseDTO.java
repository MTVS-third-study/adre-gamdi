package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlaceParseDTO {

    private Long placeNo;
    private String placeName;
    private String categoryName;
    private String cityName;
    private String dongName;
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
    private List<String> tagList;
}
