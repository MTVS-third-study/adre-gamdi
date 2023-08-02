package com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class TotalScheduleNo implements Serializable {
    @Column
    private Long scheduleNo; // 스케줄 (FK)

    protected TotalScheduleNo() {
    }

    public TotalScheduleNo(Long scheduleNo) {
        this.scheduleNo = scheduleNo;
    }
}
