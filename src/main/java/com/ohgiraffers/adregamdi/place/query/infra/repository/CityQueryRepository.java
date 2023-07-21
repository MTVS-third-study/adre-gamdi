package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityQueryRepository extends JpaRepository<City, Integer> {

    City findCityByCityName(String cityName);
}
