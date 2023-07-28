package com.ohgiraffers.adregamdi.detailschedule.command.domain.repository;

import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DetailScheduleRepository extends JpaRepository<DetailSchedule, Long> {
}
