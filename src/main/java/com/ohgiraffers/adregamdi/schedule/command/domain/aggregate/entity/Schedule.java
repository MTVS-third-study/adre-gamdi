package com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.Day;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.UserNo;

public class Schedule {

    private int scheduleNo; // pk
    private UserNo userNo; // fk
    private String scheduleName;

    private Day day;

//    private Date startDay;
//    private Date endDay;

}
