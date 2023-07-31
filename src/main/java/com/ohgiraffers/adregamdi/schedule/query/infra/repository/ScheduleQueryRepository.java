package com.ohgiraffers.adregamdi.schedule.query.infra.repository;

import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.entity.Schedule;
import com.ohgiraffers.adregamdi.schedule.command.domain.aggregate.vo.ScheduleUserNoVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScheduleQueryRepository extends JpaRepository<Schedule, Long>{

    @Query(value = "SELECT schedule_no" +
            "    , schedule_name" +
            "    , user_no" +
            "    , start_day" +
            "    , end_day" +
            "    , day_and_night" +
            " FROM TBL_SCHEDULE " +
            "WHERE USER_NO = :userNo", nativeQuery = true)
    List<Schedule> findScheduleListByUserNo(@Param("userNo") Long userNo);

    Schedule findByScheduleNo(Long scheduleNo);
}
