package com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity;


import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.TotalScheduleNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "TBL_DetailSchedule")
public class DetailSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailScheduleNo;
    @Column
    private int scheduleNo; // 순번 -> pk auto 오름차순해서 조회
    @Column
    private int scheduleDay; // 일 차
    @Embedded
    private TotalScheduleNo totalScheduleNo; //   private int scheduleNo; // 스케줄 (FK)
    @Embedded
    private PlaceNo placeNo; //   private int placeNo; // 장소 (FK)

    public DetailSchedule(Long detailScheduleNo, int scheduleNo, int scheduleDay, TotalScheduleNo totalScheduleNo, PlaceNo placeNo) {
        this.detailScheduleNo = detailScheduleNo;
        this.scheduleNo = scheduleNo;
        this.scheduleDay = scheduleDay;
        this.totalScheduleNo = totalScheduleNo;
        this.placeNo = placeNo;
    }

    public DetailSchedule(int scheduleNo, int scheduleDay, TotalScheduleNo totalScheduleNo, PlaceNo placeNo) {
        this.scheduleNo = scheduleNo;
        this.scheduleDay = scheduleDay;
        this.totalScheduleNo = totalScheduleNo;
        this.placeNo = placeNo;
    }
}
