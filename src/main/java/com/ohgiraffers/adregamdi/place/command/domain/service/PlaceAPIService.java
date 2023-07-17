package com.ohgiraffers.adregamdi.place.command.domain.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;

public interface PlaceAPIService {


    Category findCategoryByCategoryName(String categoryName);
    Tag findTagByTagName(String tagName);
    City findCityByCityName(String cityName);
    Dong findDongByDongName(String dongName);
    Place findPlaceByPlaceNameAndRoadPlaceAddress(String placeName, String roadPlaceAddress);
}
