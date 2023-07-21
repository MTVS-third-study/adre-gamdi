package com.ohgiraffers.adregamdi.data.command.infra.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.application.service.CategoryService;
import com.ohgiraffers.adregamdi.category.query.application.service.CategoryQueryService;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.service.CityService;
import com.ohgiraffers.adregamdi.cityanddong.command.application.service.DongService;
import com.ohgiraffers.adregamdi.cityanddong.query.application.service.CityQueryService;
import com.ohgiraffers.adregamdi.cityanddong.query.application.service.DongQueryService;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataAPIService;
import com.ohgiraffers.adregamdi.place.command.application.service.PlaceService;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.query.application.service.DataQueryService;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataInfraAPIService implements DataAPIService {

    private final DataQueryService dataQueryService;
    private final CategoryQueryService categoryQueryService;
    private final CategoryService categoryService;
    private final CityQueryService cityQueryService;
    private final CityService cityService;
    private final DongQueryService dongQueryService;
    private final DongService dongService;
    private final PlaceService placeService;

    @Autowired
    public DataInfraAPIService(DataQueryService dataQueryService,
                               CategoryQueryService categoryQueryService,
                               CategoryService categoryService,
                               CityQueryService cityQueryService,
                               CityService cityService,
                               DongQueryService dongQueryService,
                               DongService dongService,
                               PlaceService placeService) {
        this.dataQueryService = dataQueryService;
        this.categoryQueryService = categoryQueryService;
        this.categoryService = categoryService;
        this.cityQueryService = cityQueryService;
        this.cityService = cityService;
        this.dongQueryService = dongQueryService;
        this.dongService = dongService;
        this.placeService = placeService;
    }
    @Override
    public CategoryDTO findCategoryByCategoryName(String categoryName) {
        return categoryQueryService.findCategoryByCategoryName(categoryName);
    }
    @Override
    public CategoryDTO insertCategory(String categoryName) {
        return categoryService.insertCategory(categoryName);
    }

    @Override
    public CityDTO findCityByCityName(String cityName) {
        return cityQueryService.findCityByCityName(cityName);
    }
    @Override
    public CityDTO insertCity(String cityName) {
        return cityService.insertCity(cityName);
    }

    @Override
    public DongDTO findDongByDongName(String dongName) {
        return dongQueryService.findDongByDongName(dongName);
    }
    @Override
    public DongDTO insertDong(DongDTO dongDTO) {
        return dongService.insertDong(dongDTO);
    }

    @Override
    public DataDTO insertPlace(DataDTO dataDTO) {
        return placeService.insertPlace(dataDTO);
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
