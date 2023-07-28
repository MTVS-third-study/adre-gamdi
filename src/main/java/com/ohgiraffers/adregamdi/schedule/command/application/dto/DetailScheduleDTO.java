package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import lombok.*;

import java.util.Map;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DetailScheduleDTO {

    private String dayAndNight;
    private Map<String, Objects> travelDays;
}
