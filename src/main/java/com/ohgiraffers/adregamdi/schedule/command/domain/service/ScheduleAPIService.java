package com.ohgiraffers.adregamdi.schedule.command.domain.service;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;

import java.util.List;

public interface ScheduleAPIService {

    List<DetailScheduleDTO> insertDetailSchedule(List<DetailScheduleDTO> detailScheduleDTOList);

}
