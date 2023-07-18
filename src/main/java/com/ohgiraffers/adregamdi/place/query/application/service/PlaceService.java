package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

import static com.ohgiraffers.adregamdi.common.Template.getSqlSession;

public class PlaceService {

    public void searchMapByKeyword(){
        SqlSession sqlSession = getSqlSession();
        PlaceMapper mapper = sqlSession.getMapper(PlaceMapper.class);

        List<SearchPlace> places = mapper.searchPlace();

    }
}
