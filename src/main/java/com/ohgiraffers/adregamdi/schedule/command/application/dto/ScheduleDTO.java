package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDTO {

    private String scheduleName;
    private Long userNo;
    private String startDay;
    private String endDay;
}
