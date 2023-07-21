package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.command.application.service.DataService;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.City;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Dong;
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
class DataQueryServiceTest {

    @Autowired
    private DataQueryService dataQueryService;
    @Autowired
    private DataService dataService;

    @DisplayName("카테고리 조회 테스트")
    @Test
    void testFindCategoryByCategoryName() {

        // given
        Category category = new Category("관광지");
        dataService.insertCategory(category);

        // when & then
        Assertions.assertDoesNotThrow(
                () ->dataQueryService.findCategoryByCategoryName(category.getCategoryName())
                );
    }

    @DisplayName("카테고리 조회 실패 시 반환 값이 null인지 확인")
    @Test
    void testCheckNullFindCategoryResultWhenNoResult() {

        // given
        String categoryName = "소소소견";

        // when
        Category result = dataQueryService.findCategoryByCategoryName(categoryName);

        // then
        Assertions.assertNull(result);
    }

    @DisplayName("시 조회 테스트")
    @Test
    void testFindCityByCityName() {

        // given
        City city = new City("제주도도");
        dataService.insertCity(city);

        // when & then
        Assertions.assertDoesNotThrow(
                () ->dataQueryService.findCityByCityName(city.getCityName())
        );
    }

    @DisplayName("시 정보 조회 실패 시 반환 값이 null인지 확인")
    @Test
    void testCheckNullFindCityResultWhenNoResult() {

        // given
        String cityName = "관광지";

        // when
        City result = dataQueryService.findCityByCityName(cityName);

        // then
        Assertions.assertNull(result);
    }

    @DisplayName("동 정보 조회 테스트")
    @Test
    void testFindDongByDongName() {

        // given
        Dong dong = new Dong(1, "제주도도");
        dataService.insertDong(dong);

        // when & then
        Assertions.assertDoesNotThrow(
                () ->dataQueryService.findDongByDongName(dong.getDongName())
        );
    }

    @DisplayName("동 정보 조회 실패 시 반환 값이 null인지 확인")
    @Test
    void testCheckNullFindDongResultWhenNoResult() {

        // given
        String dongName = "관광동";

        // when
        Dong result = dataQueryService.findDongByDongName(dongName);

        // then
        Assertions.assertNull(result);
    }

}