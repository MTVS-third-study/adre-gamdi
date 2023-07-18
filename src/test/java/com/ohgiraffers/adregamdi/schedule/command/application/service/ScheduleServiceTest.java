package com.ohgiraffers.adregamdi.schedule.command.application.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
class ScheduleServiceTest {

    @Autowired
    private ScheduleService scheduleService;

//    @DisplayName("insertSchedule 생성 확인")
//    @Test
//    private void testInsertScheduleService() {
//
//        // given
//        List<>
//
//        // when
//
//        // then
//    }


}