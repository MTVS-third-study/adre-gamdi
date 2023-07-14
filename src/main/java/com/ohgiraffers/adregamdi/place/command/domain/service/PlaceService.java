package com.ohgiraffers.adregamdi.place.command.domain.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;

public interface PlaceService {
    Place insertPlace();
    Place updatePlace();
    void deletePlace();
}
