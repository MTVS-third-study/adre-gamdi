package com.ohgiraffers.adregamdi.schedule.query.infra.repository;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleQueryRepository extends JpaRepository<Schedule, Long> {

    Schedule findByScheduleName(Long userNo);
}
