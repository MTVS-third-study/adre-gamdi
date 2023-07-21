package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PlaceQueryService {

    private final PlaceMapper placeMapper;

    @Autowired
    public PlaceQueryService(PlaceMapper placeMapper){
        this.placeMapper = placeMapper;
    }

    public List<SearchPlace> findPlaceByKeyword(String keyword){
        List<SearchPlace> placeList = placeMapper.searchPlace(keyword);
        return placeList;
    }
}
