package com.ohgiraffers.adregamdi.data.command.domain.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.PlaceTagsDataDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.TagDataDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;

public interface DataAPIService {

    CategoryDTO findCategoryByCategoryName(String categoryName);
    CategoryDTO insertCategory(String categoryName);

    CityDTO findCityByCityName(String cityName);
    CityDTO insertCity(String cityName);

    DongDTO findDongByDongName(String dongName);
    DongDTO insertDong(DongDTO dongDTO);

    Long insertPlace(DataDTO dataDTO);

    TagDataDTO findTagByTagName(String tagName);

    TagDataDTO insertTag(String tagName);

    Long insertPlaceAndTags(PlaceTagsDataDTO placeTagsDataDTO);
}
