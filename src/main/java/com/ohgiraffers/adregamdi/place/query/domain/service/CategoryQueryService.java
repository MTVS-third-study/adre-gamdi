package com.ohgiraffers.adregamdi.place.query.domain.service;

import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryQueryService {
    private final PlaceMapper placeMapper;

    @Autowired
    public CategoryQueryService(PlaceMapper placeMapper){
        this.placeMapper = placeMapper;
    }

    public String findCategoryNameByCategoryNo(int categoryNo){
        String categoryName = placeMapper.findCategoryNameByCategoryNo(categoryNo);
        return categoryName;
    }

}
