package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ScheduleDTO {

    private String scheduleName;

    private String kakaoId;    // service에서 query로 userNo 조회해오기

    private String startDay;

    private String endDay;
}
