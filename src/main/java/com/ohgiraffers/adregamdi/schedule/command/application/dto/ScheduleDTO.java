package com.ohgiraffers.adregamdi.schedule.command.application.dto;

import com.google.gson.stream.JsonToken;
import lombok.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.List;
import java.util.Objects;

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

    private JSONObject travelDays;

    public ScheduleDTO(String scheduleName, Long userNo, String startDate, String endDate) {
        this.scheduleName = scheduleName;
        this.userNo = userNo;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ScheduleDTO(Long scheduleNo, String scheduleName, Long userNo, String startDate, String endDate, String dayAndNight) {
        this.scheduleNo = scheduleNo;
        this.scheduleName = scheduleName;
        this.userNo = userNo;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayAndNight = dayAndNight;
    }
}
