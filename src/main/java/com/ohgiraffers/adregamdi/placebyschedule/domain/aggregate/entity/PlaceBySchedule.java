package com.ohgiraffers.adregamdi.placebyschedule.domain.aggregate.entity;


import com.ohgiraffers.adregamdi.placebyschedule.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.placebyschedule.domain.aggregate.vo.ProcedureSchedule;

public class PlaceBySchedule {


    private int procedureNo; // 순번 -> pk auto 오름차순해서 조회

    private int procedureDay; // 일 차

//    @Embedded
    private ProcedureSchedule procedureSchedule;
//    private int scheduleNo; // 스케줄 (FK)


//    @Embedded
    private PlaceNo placeNo;
//    private int placeNo; // 장소 (FK)
}
