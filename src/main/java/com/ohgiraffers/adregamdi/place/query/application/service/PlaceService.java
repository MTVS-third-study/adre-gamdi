package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlaceService {

    private final PlaceMapper placeMapper;

    @Autowired
    public PlaceService(PlaceMapper placeMapper){
        this.placeMapper = placeMapper;
    }

    public List<SearchPlace> findPlaceByKeyword(String keyword){
        List<SearchPlace> placeList = placeMapper.searchPlace(keyword);
        return placeList;
    }


}
