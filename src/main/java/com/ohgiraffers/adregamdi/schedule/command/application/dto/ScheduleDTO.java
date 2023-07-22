package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDTO {

    private Long scheduleNo;

    private String scheduleName;

    private Long userNo;

    private String startDay;

    private String endDay;

    private String dayAndNight;

    public ScheduleDTO(String scheduleName, Long userNo, String startDay, String endDay) {
        this.scheduleName = scheduleName;
        this.userNo = userNo;
        this.startDay = startDay;
        this.endDay = endDay;
    }

    public ScheduleDTO(String scheduleName, Long userNo, String startDay, String endDay, String dayAndNight) {
        this.scheduleName = scheduleName;
        this.userNo = userNo;
        this.startDay = startDay;
        this.endDay = endDay;
        this.dayAndNight = dayAndNight;
    }
}
