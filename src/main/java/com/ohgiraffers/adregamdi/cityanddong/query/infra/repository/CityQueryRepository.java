package com.ohgiraffers.adregamdi.cityanddong.query.infra.repository;

import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.City;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityQueryRepository extends JpaRepository<City, Integer> {

    City findCityByCityName(String cityName);
    City findCityByCityNo(int cityNo);
}
