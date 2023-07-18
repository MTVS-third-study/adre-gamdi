package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleDayVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;

public class ScheduleDTOEntityMapper {

    public Schedule scheduleDTOtoScedule(ScheduleDTO scheduleDTO) {
        return new Schedule(
                new ScheduleUserNoVO(scheduleDTO.getUserNo()),
                scheduleDTO.getScheduleName(),
                new ScheduleDayVO(scheduleDTO.getStartDay(), scheduleDTO.getEndDay())
        );
    }
}
