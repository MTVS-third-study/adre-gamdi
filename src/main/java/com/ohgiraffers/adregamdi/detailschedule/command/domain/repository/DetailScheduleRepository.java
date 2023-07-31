package com.ohgiraffers.adregamdi.detailschedule.command.domain.repository;

import com.ohgiraffers.adregamdi.detailschedule.command.domain.aggregate.entity.DetailSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DetailScheduleRepository extends JpaRepository<DetailSchedule, Long> {

    @Modifying
    @Query(value = "DELETE " +
            " FROM TBL_DETAIL_SCHEDULE " +
            "WHERE SCHEDULE_NO = :scheduleNo", nativeQuery = true)
    int deleteDetailScheduleByscheduleNo(@Param("scheduleNo") Long scheduleNo);
}
