package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.query.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import com.ohgiraffers.adregamdi.place.query.domain.service.CategoryQueryService;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlaceQueryService {

    private final PlaceMapper placeMapper;
    private final CategoryQueryService categoryQueryService;

    @Autowired
    public PlaceQueryService(PlaceMapper placeMapper,
                             CategoryQueryService categoryQueryService){
        this.placeMapper = placeMapper;
        this.categoryQueryService = categoryQueryService;
    }

    public List<PlaceDTO> findPlaceByKeyword(String keyword){
        List<SearchPlace> noPlaceList = placeMapper.searchPlace(keyword);
        List<PlaceDTO> placeList = new ArrayList<>();
        int num = noPlaceList.size() - 1;
        for (int i = 0; i <= num; i++) {
            placeList.add(new PlaceDTO(noPlaceList.get(i).getPlaceNo(),
                    noPlaceList.get(i).getPlaceName(),
                    categoryQueryService.findCategoryNameByCategoryNo(noPlaceList.get(i).getCategoryNo()),
                    noPlaceList.get(i).getCityNo(),
                    noPlaceList.get(i).getDongNo(),
                    noPlaceList.get(i).getIntroduction(),
                    noPlaceList.get(i).getPhoneNumber(),
                    noPlaceList.get(i).getLatitude(),
                    noPlaceList.get(i).getLongitude(),
                    noPlaceList.get(i).getPostCode(),
                    noPlaceList.get(i).getPlaceAddress(),
                    noPlaceList.get(i).getRoadPlaceAddress(),
                    noPlaceList.get(i).getImagePath(),
                    noPlaceList.get(i).getThumbnailPath(),
                    noPlaceList.get(i).getAverageStarPoint(),
                    noPlaceList.get(i).getReviewCount()));
        }




        return placeList;
    }



}
