package com.ohgiraffers.adregamdi.place.command.infra.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;
import com.ohgiraffers.adregamdi.place.command.domain.service.PlaceAPIService;
import com.ohgiraffers.adregamdi.place.query.application.service.DataQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class PlaceInfraAPIService implements PlaceAPIService {

    private final DataQueryService dataQueryService;

    @Autowired
    public PlaceInfraAPIService(DataQueryService dataQueryService) {
        this.dataQueryService = dataQueryService;
    }

    @Override
    public Category findCategoryByCategoryName(String categoryName) {
        return dataQueryService.findCategoryByCategoryName(categoryName);
    }
    @Override
    public City findCityByCityName(String cityName) {
        return dataQueryService.findCityByCityName(cityName);
    }

    @Override
    public Dong findDongByDongName(String dongName) {
        return dataQueryService.findDongByDongName(dongName);
    }

    @Override
    public Tag findTagByTagName(String tagName) {
        return dataQueryService.findTagByTagName(tagName);
    }

    @Override
    public Place findPlaceByPlaceNameAndRoadPlaceAddress(String placeName, String roadPlaceAddress) {
        return dataQueryService.findPlaceByPlaceNameAndRoadPlaceAddress(placeName,roadPlaceAddress);
    }


}
