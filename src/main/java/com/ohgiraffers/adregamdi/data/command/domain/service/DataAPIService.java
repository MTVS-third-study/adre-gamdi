package com.ohgiraffers.adregamdi.data.command.domain.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;

public interface DataAPIService {

    CategoryDTO findCategoryByCategoryName(String categoryName);
    CategoryDTO insertCategory(String categoryName);

    CityDTO findCityByCityName(String cityName);
    CityDTO insertCity(String cityName);

    DongDTO findDongByDongName(String dongName);
    DongDTO insertDong(DongDTO dongDTO);

    Long insertPlace(DataDTO dataDTO);

    TagDTO findTagByTagName(String tagName);

    TagDTO insertTag(String tagName);

    Long insertPlaceAndTags(PlaceTagsDTO placeTagsDTO);
}
