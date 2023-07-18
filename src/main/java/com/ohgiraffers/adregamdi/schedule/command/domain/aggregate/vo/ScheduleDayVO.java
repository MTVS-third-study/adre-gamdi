package com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.sql.Date;
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
    private Long dayAndNight;    // 필기. 몇박몇일

    public ScheduleDayVO() {
    }

    public ScheduleDayVO(String startDay, String endDay, Long dayAndNight) {
        this.startDay = startDay;
        this.endDay = endDay;
        this.dayAndNight = getDayAndNight(startDay,endDay);
    }

    private Long getDayAndNight(String startDay, String endDay) {

        Date format1 = null;
        Date format2 = null;
        try {
            format1 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(startDay);
            format2 = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(endDay);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        long diffSec = (format2.getTime() - format1.getTime()) / 1000;
        long diffDay = diffSec / (24*60*60);

        return diffDay;
    }

}
