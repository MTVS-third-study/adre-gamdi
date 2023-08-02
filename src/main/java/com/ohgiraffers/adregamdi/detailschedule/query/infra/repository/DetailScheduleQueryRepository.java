package com.ohgiraffers.adregamdi.detailschedule.query.infra.repository;

import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.vo.TotalScheduleNo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DetailScheduleQueryRepository extends JpaRepository<DetailSchedule, Long> {

    List<DetailSchedule> findAllByTotalScheduleNo(TotalScheduleNo totalScheduleNo);
}
