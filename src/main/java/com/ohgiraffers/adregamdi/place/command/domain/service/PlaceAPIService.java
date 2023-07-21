package com.ohgiraffers.adregamdi.place.command.domain.service;

import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;

public interface PlaceAPIService {


    Category findCategoryByCategoryName(String categoryName);
    Tag findTagByTagName(String tagName);
    City findCityByCityName(String cityName);
    Dong findDongByDongName(String dongName);
    Place findPlaceByPlaceNameAndRoadPlaceAddress(String placeName, String roadPlaceAddress);
}
