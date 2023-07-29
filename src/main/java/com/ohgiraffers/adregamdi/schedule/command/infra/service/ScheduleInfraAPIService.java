package com.ohgiraffers.adregamdi.schedule.command.infra.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.command.application.service.DetailScheduleService;
import com.ohgiraffers.adregamdi.schedule.command.domain.service.ScheduleAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScheduleInfraAPIService implements ScheduleAPIService {

    private final DetailScheduleService detailScheduleService;

    @Autowired
    public ScheduleInfraAPIService(DetailScheduleService detailScheduleService) {
        this.detailScheduleService = detailScheduleService;
    }

    @Override
    public List<DetailScheduleDTO> insertDetailSchedule(List<DetailScheduleDTO> detailScheduleDTOList) {
        List<DetailScheduleDTO> result = detailScheduleService.registDetailSchedule(detailScheduleDTOList);
        return result;
    }
}
