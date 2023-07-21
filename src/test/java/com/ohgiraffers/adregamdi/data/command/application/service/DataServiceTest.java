package com.ohgiraffers.adregamdi.data.command.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.TagDataDTO;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataDomainService;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.CategoryVO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.CityVO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.CoordinateVO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.DongVO;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
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
class DataServiceTest {

    @Autowired
    private DataService dataService;

    @Autowired
    private DataDomainService dataDomainService;

    @DisplayName("파싱한 Category 정보가 정상적으로 insert 되는지 확인")
    @Test
    void insertCategory() {
        // given
        String categoryName = "관광지";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertCategory(categoryName)
        );
    }

    @DisplayName("파싱한 Category 정보가 이미 존재할 때 존재하는 City 정보를 반환해주는지 확인")
    @Test
    void testInsertCategoryResultWhenCategoryInfoIsDuplicate() {

        // given
        String categoryName = "관광지";
        CategoryDTO insertResult = dataService.insertCategory(categoryName);

        // when
        CategoryDTO duplicateResult = dataService.insertCategory(insertResult.getCategoryName());

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 City 정보가 정상적으로 insert 되는지 확인")
    @Test
    void insertCity() {
        // given
        String cityName = "제주시";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertCity(cityName)
        );
    }

    @DisplayName("파싱한 City 정보가 이미 존재할 때 존재하는 City 정보를 반환해주는지 확인")
    @Test
    void testInsertCityResultWhenCityInfoIsDuplicate() {

        // given
        String cityName = "제주시치";
        CityDTO insertResult = dataService.insertCity(cityName);

        // when
        CityDTO duplicateResult = dataService.insertCity(insertResult.getCityName());

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 Dong 정보가 정상적으로 insert 되는지 확인")
    @Test
    void insertDong() {
        // given
        int dongCode = 11;
        String dongName = "제주동";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertDong(dongCode, dongName)
        );
    }

    @DisplayName("파싱한 Dong 정보가 이미 존재할 때 존재하는 Dong 정보를 반환해주는지 확인")
    @Test
    void testInsertDongResultWhenDongInfoIsDuplicate() {

        // given
        int dongCode = 11;
        String dongName = "제주동";
        DongDTO insertResult = dataService.insertDong(dongCode, dongName);

        // when
        DongDTO duplicateResult = dataService.insertDong(insertResult.getDongNo(), insertResult.getDongName());

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 Place 정보들이 정상적으로 insert 되는지 확인")
    @Test
    void insertPlace() {
        // given
        DataDTO dataDTO = new DataDTO(
                1,
                "음식점",
                1,
                "제주",
                1,
                "한림",
                "연돈",
                "아아",
                "1234",
                33.33,
                126.123,
                "123142",
                "여기",
                "저기",
                "이미지경로",
                "썸네일경로"
        );

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertPlace(dataDTO)
        );

    }

    @DisplayName("파싱한 Place 정보가 이미 존재할 때 존재하는 Place 정보를 반환해주는지 확인")
    @Test
    void testInsertPlaceResultWhenPlaceInfoIsDuplicate() {

        // given
        DataDTO dataDTO = new DataDTO(
                1,
                "음식점",
                1,
                "제주",
                1,
                "한림",
                "연돈",
                "아아",
                "1234",
                33.33,
                126.123,
                "123142",
                "여기",
                "저기",
                "이미지경로",
                "썸네일경로"
        );
        Long insertResult = dataService.insertPlace(dataDTO);

        // when
        Long duplicateResult = dataService.insertPlace(dataDTO);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 TagList 정보가 정상적으로 insert 되는지 확인")
    @Test
    void insertTag() {
        // given
        String tagName = "제중";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertTag(tagName)
        );
    }

    @DisplayName("파싱한 Tag 정보가 이미 존재할 때 존재하는 Tag 정보를 반환해주는지 확인")
    @Test
    void testInsertTagResultWhenTagInfoIsDuplicate() {

        // given
        String tagName = "제중";
        TagDataDTO insertResult = dataService.insertTag(tagName);

        // when
        TagDataDTO duplicateResult = dataService.insertTag(tagName);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }
}