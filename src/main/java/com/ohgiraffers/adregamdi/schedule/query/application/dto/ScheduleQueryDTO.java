package com.ohgiraffers.adregamdi.schedule.query.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleQueryDTO {

    private Long scheduleNo;
    private Long userNo;
    private String scheduleName;
    private String startDay;
    private String endDay;
    private Long dayAndNight;


}
