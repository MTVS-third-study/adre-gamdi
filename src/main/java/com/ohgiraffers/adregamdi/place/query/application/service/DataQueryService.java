package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;
import com.ohgiraffers.adregamdi.place.query.infra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataQueryService {

    private final PlaceQueryRepository placeQueryRepository;
    private final CategoryQueryRepository categoryQueryRepository;
    private final CityQueryRepository cityQueryRepository;
    private final DongQueryRepository dongQueryRepository;
    private final TagQueryRepository tagQueryRepository;



    @Autowired
    public DataQueryService(PlaceQueryRepository placeQueryRepository,
                            CategoryQueryRepository categoryQueryRepository,
                            CityQueryRepository cityQueryRepository,
                            DongQueryRepository dongQueryRepository,
                            TagQueryRepository tagQueryRepository) {
        this.placeQueryRepository = placeQueryRepository;
        this.categoryQueryRepository = categoryQueryRepository;
        this.cityQueryRepository = cityQueryRepository;
        this.dongQueryRepository = dongQueryRepository;
        this.tagQueryRepository = tagQueryRepository;
    }

    public Tag findTagByTagName(String tagName) {
        Tag result = tagQueryRepository.findByTagName(tagName);
        return result;
    }

    public Category findCategoryByCategoryName(String categoryName) {
        Category result = categoryQueryRepository.findCategoryByCategoryName(categoryName);
        return result;
    }

    public City findCityByCityName(String cityName) {
        City result = cityQueryRepository.findCityByCityName(cityName);
        return result;
    }

    public Dong findDongByDongName(String dongName) {
        Dong result = dongQueryRepository.findDongByDongName(dongName);
        return result;
    }

    public Place findPlaceByPlaceNameAndRoadPlaceAddress(String placeName, String roadPlaceAddress){
        Place result = placeQueryRepository.findPlaceByPlaceNameAndRoadPlaceAddress(placeName, roadPlaceAddress);
        return result;
    }



}
