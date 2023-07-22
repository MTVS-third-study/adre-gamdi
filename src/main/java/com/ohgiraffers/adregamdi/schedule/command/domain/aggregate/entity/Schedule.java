package com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleDayVO;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBL_SCHEDULE")
public class Schedule {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleNo;

    @Embedded
    private ScheduleUserNoVO scheduleUserNoVO;
    @Column(nullable = false)
    private String scheduleName;
    @Embedded
    private ScheduleDayVO scheduleDayVO;

    public Schedule(ScheduleUserNoVO scheduleUserNoVO, String scheduleName, ScheduleDayVO scheduleDayVO) {
        this.scheduleUserNoVO = scheduleUserNoVO;
        this.scheduleName = scheduleName;
        this.scheduleDayVO = scheduleDayVO;
    }
}
