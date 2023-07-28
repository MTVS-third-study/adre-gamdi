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

    private String startDate;

    private String endDate;

    private String dayAndNight;

    public ScheduleDTO(String scheduleName, Long userNo, String startDate, String endDate) {
        this.scheduleName = scheduleName;
        this.userNo = userNo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
