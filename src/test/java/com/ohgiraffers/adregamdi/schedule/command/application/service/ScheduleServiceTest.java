package com.ohgiraffers.adregamdi.schedule.command.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SpringBootTest
@AutoConfigureDataJpa
@Transactional
class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;

    @DisplayName("insertSchedule 생성 확인")
    @Test
    void testInsertScheduleService() {

        // given
        ScheduleDTO schedule = new ScheduleDTO(
                "제주제주",
                null,
                "kakao@duam.net",
                "2023-07-07",
                "2023-07-08"
        );

        // when & then
        Assertions.assertDoesNotThrow(
                () -> scheduleService.insertSchedule(schedule)
        );

    }

//    @DisplayName("deleteSchedule 삭제 확인")
//    @Test
//    void testDeleteScheduleService() {
//
//        // given
//
//
//        // when & then
//        Assertions.assertDoesNotThrow(
//                () -> scheduleService.deleteSchedule(sc)
//        );
//    }

}