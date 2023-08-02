package com.ohgiraffers.adregamdi.cityanddong.query.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.Dong;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DongQueryServiceTest {

    @Autowired
    private DongQueryService dongQueryService;

    @DisplayName("동 정보 조회 테스트")
    @Test
    void findDongByDongName() {

        // given
        String dongName = "제주도도";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dongQueryService.findDongByDongName(dongName)
        );
    }

}