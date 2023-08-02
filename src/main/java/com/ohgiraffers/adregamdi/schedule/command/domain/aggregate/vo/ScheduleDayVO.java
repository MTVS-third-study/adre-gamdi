package com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Getter
@Embeddable
public class ScheduleDayVO {

    @Column
    private String startDay;
    @Column
    private String endDay;

    @Column
    private String dayAndNight;    // 필기. 몇박몇일

    public ScheduleDayVO() {
    }

    public ScheduleDayVO(String startDay, String endDay) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.dayAndNight = getDayAndNight(startDay,endDay);
    }

    private String getDayAndNight(String startDay, String endDay) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date format1 = null;
        Date format2 = null;
        try {
            format1 = dateFormat.parse(startDay);
            format2 = dateFormat.parse(endDay);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long diffSec = (format2.getTime() - format1.getTime()) / 1000;
        long diffDay = diffSec / (24*60*60);

        return String.valueOf(diffDay + 1);
    }

}
