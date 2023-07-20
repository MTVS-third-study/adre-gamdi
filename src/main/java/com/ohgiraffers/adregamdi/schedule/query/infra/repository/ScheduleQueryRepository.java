package com.ohgiraffers.adregamdi.schedule.query.infra.repository;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleQueryRepository extends JpaRepository<Schedule, Long> {

    List<Schedule> findAllByScheduleUserNoVO(ScheduleUserNoVO scheduleUserNoVO);
}
