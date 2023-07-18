package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;

import java.util.List;

public interface PlaceMapper {
    List<SearchPlace> searchPlace();

}
