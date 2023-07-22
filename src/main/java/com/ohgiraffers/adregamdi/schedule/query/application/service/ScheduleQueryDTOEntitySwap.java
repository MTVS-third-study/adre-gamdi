package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;

public class ScheduleQueryDTOEntitySwap {


    public ScheduleDTO scheduleToScheduleDTO(Schedule schedule){
        ScheduleDTO scheduleQueryDTO = new ScheduleDTO(
                schedule.getScheduleNo(),
                schedule.getScheduleName(),
                schedule.getScheduleUserNoVO().getUserNo(),
                schedule.getScheduleDayVO().getStartDay(),
                schedule.getScheduleDayVO().getEndDay(),
                schedule.getScheduleDayVO().getDayAndNight()
        );
        return scheduleQueryDTO;
    }
}
