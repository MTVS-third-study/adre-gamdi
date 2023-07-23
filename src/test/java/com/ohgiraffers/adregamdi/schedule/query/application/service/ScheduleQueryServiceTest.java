package com.ohgiraffers.adregamdi.schedule.query.application.service;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.application.service.ScheduleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@AutoConfigureDataJpa
@Transactional
class ScheduleQueryServiceTest {

    @Autowired
    private ScheduleQueryService scheduleQueryService;
    @Autowired
    private ScheduleService scheduleService;

    @DisplayName("userNo로 내 일정 조회 테스트")
    @Test
    void loadMyScheduleList() {

        // given
        ScheduleDTO schedule = new ScheduleDTO(
                "제주제주",
                10L,
                "kakao@duam.net",
                "2023-07-07",
                "2023-07-08"
        );
        Long userNo = 10L;

        // when & then
        Assertions.assertDoesNotThrow(
                () -> scheduleQueryService.loadMyScheduleList(userNo)
        );
    }
}