package com.ohgiraffers.adregamdi.schedule.command.domain.repository;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
