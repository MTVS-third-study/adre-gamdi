package com.ohgiraffers.adregamdi.detailschedule.query.infra.repository;

import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DetailScheduleQueryRepository extends JpaRepository<DetailSchedule, Long> {

}
