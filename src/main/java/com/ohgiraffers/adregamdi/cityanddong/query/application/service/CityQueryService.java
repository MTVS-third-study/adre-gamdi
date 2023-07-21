package com.ohgiraffers.adregamdi.cityanddong.query.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.City;
import com.ohgiraffers.adregamdi.cityanddong.query.application.dto.CityQueryDTO;
import com.ohgiraffers.adregamdi.cityanddong.query.infra.repository.CityQueryRepository;
import org.springframework.stereotype.Service;

@Service
public class CityQueryService {

    private final CityQueryRepository cityQueryRepository;

    public CityQueryService(CityQueryRepository cityQueryRepository) {
        this.cityQueryRepository = cityQueryRepository;
    }

    public CityQueryDTO findCityByCityName(String cityName) {

        City result = cityQueryRepository.findCityByCityName(cityName);

        return new CityQueryDTO(
                result.getCityNo(),
                result.getCityName()
        );
    }


}
