package com.ohgiraffers.adregamdi.data.command.application.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DataDto {

    /* 카테고리*/
    private String categoryName;

    /* 도시 */
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

    /* 태그 */
    private List<String> tagList;

}
