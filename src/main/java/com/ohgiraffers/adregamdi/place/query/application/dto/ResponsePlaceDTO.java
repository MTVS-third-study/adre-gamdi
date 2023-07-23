package com.ohgiraffers.adregamdi.place.query.application.dto;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePlaceDTO {

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
