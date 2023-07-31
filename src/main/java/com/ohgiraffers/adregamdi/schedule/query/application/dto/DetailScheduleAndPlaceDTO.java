package com.ohgiraffers.adregamdi.schedule.query.application.dto;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.query.application.dto.ResponsePlaceDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetailScheduleAndPlaceDTO {

    private DetailScheduleDTO detailScheduleDTO;
    private ResponsePlaceDTO responsePlaceDTO;
}
