package com.ohgiraffers.adregamdi.schedule.query.application.dto;


import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class LoadMyScheduleDTO {

    private Long scheduleNo;
    private String scheduleName;
    private String startDate;
    private String endDate;
    private String dayAndNight;

    private Map<String, List<DetailScheduleAndPlaceDTO>> detailScheduleList;
    private String message;

    public LoadMyScheduleDTO(Long scheduleNo, String scheduleName, String startDate, String endDate, String dayAndNight, Map<String, List<DetailScheduleAndPlaceDTO>> detailScheduleList) {
        this.scheduleNo = scheduleNo;
        this.scheduleName = scheduleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.dayAndNight = dayAndNight;
        this.detailScheduleList = detailScheduleList;
    }

    public LoadMyScheduleDTO(String message) {
        this.message = message;
    }
}
