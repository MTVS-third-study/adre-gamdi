package com.ohgiraffers.adregamdi.schedule.query.application.dto;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MyScheduleResponseDTO {

    private List<ScheduleDTO> myScheduleList;
    private String message;

    public MyScheduleResponseDTO(List<ScheduleDTO> myScheduleList) {
        this.myScheduleList = myScheduleList;
    }

    public MyScheduleResponseDTO(String message) {
        this.message = message;
    }
}