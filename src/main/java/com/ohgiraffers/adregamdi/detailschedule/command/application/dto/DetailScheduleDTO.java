package com.ohgiraffers.adregamdi.detailschedule.command.application.dto;

import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.TotalScheduleNo;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DetailScheduleDTO {
        private Long detailScheduleNo;
        private int procedureNo;
        private int scheduleDay;
        private TotalScheduleNo totalScheduleNo;
        private Long placeNo;
}

