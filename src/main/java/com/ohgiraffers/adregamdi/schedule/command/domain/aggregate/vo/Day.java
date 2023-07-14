package com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo;

import java.sql.Date;

public class Day {

    private Date startDay;
    private Date endDay;

    private int dayAndNight;    // 필기. 몇박몇일

    public Day() {
    }

    public Day(Date startDay, Date endDay, int dayAndNight) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.dayAndNight = getDayAndNight();
    }

    private int getDayAndNight() {
        return 0;
    }


}
