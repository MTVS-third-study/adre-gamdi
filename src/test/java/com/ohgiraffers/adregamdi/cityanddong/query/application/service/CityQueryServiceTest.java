package com.ohgiraffers.adregamdi.cityanddong.query.application.service;

import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.domain.aggregate.entity.City;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class CityQueryServiceTest {

    @Autowired
    private CityQueryService cityQueryService;

    @DisplayName("시 조회 테스트")
    @Test
    void findCityByCityName() {

        // given
        String cityName = "제주도도";

        /// when & then
        Assertions.assertDoesNotThrow(
                () -> cityQueryService.findCityByCityName(cityName)
        );
    }

    @DisplayName("시 정보 조회 실패 시 반환 값이 null인지 확인")
    @Test
    void testCheckNullFindCityResultWhenNoResult() {

        // given
        String cityName = "관광지";

        // when
        CityDTO result = cityQueryService.findCityByCityName(cityName);

        // then
        Assertions.assertNull(result);
    }
}