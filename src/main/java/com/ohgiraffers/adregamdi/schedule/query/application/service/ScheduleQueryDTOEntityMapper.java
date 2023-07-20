package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.ScheduleQueryDTO;

public class ScheduleQueryDTOEntityMapper {

//    public Schedule scheduleQueryDTOtoScehdule(ScheduleQueryDTO scheduleQueryDTO) {
//        return new Schedule()
//    }

    public ScheduleQueryDTO scheduleToScheduleQueryDTO(Schedule schedule){
        ScheduleQueryDTO scheduleQueryDTO = new ScheduleQueryDTO(
                schedule.getScheduleNo(),
                schedule.getScheduleUserNoVO().getUserNo(),
                schedule.getScheduleName(),
                schedule.getScheduleDayVO().getStartDay(),
                schedule.getScheduleDayVO().getEndDay(),
                schedule.getScheduleDayVO().getDayAndNight()
        );
        return scheduleQueryDTO;
    }
}
