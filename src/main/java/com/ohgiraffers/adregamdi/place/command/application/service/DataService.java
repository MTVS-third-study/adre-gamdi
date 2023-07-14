package com.ohgiraffers.adregamdi.place.command.application.service;

import com.ohgiraffers.adregamdi.place.command.domain.service.DataDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataDomainService dataDomainService;

    @Autowired
    public DataService(DataDomainService dataDomainService) {
        this.dataDomainService = dataDomainService;
    }

    public void getPlaceData() {

        dataDomainService.getPlaceData();

    }
}
