package com.ohgiraffers.adregamdi.data.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataDTO {

    /* 카테고리*/
    private int categoryNo;
    private String categoryName;

    /* 도시 */
    private int cityNo;
    private String cityName;

    /* 동 */
    private int dongCode;
    private String dongName;

    /* 장소 정보 */
    private String placeName;
    private String placeIntroduction;
    private String phoneNo;
    private double lat;
    private double lng;
    private String postCode;
    private String address;
    private String roadAddress;
    private String imagePath;
    private String thumbnailPath;

}
