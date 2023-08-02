package com.ohgiraffers.adregamdi.cityanddong.command.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.City;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public CityDTO insertCity(String cityName) {
        City insertedCity = cityRepository.save(new City(cityName));
        if (insertedCity == null) {
            return new CityDTO();
        }
        return new CityDTO(
            insertedCity.getCityNo(),
            insertedCity.getCityName()
        );
    }
}
