package com.ohgiraffers.adregamdi.place.command.application.service;

import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.*;
import com.ohgiraffers.adregamdi.place.command.domain.service.DataDomainService;
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
public class DataServiceTest {

    @Autowired
    private DataService dataService;
    @Autowired
    private DataDomainService dataDomainService;

    @DisplayName("파싱한 Place 정보들이 정상적으로 insert 되는지 확인")
    @Test
    void testInsertPlace() {
        // given
        Place place = new Place( "제주",
                new CategoryVO(1),
                new CityVO(1),
                new DongVO(1),
                "아아",
                "064-12312",
                new CoordinateVO(33.33, 126.123),
                "123142",
                "여기",
                "저기",
                "이미지경로",
                "썸네일경로",
                0,
                0
                );

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertPlace(place)
        );
//        Assertions.assertEquals(place,dataService.insertPlace(place));
    }

    @DisplayName("파싱한 Place 정보가 이미 존재할 때 존재하는 Place 정보를 반환해주는지 확인")
    @Test
    void testInsertPlaceResultWhenPlaceInfoIsDuplicate() {

        // given
        Place place = new Place( "제주",
                new CategoryVO(1),
                new CityVO(1),
                new DongVO(1),
                "아아",
                "064-12312",
                new CoordinateVO(33.33, 126.123),
                "123142",
                "여기",
                "저기",
                "이미지경로",
                "썸네일경로",
                0,
                0
        );
        Place insertResult = dataService.insertPlace(place);

        // when
        Place duplicateResult = dataService.insertPlace(place);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 Category 정보가 정상적으로 insert 되는지 확인")
    @Test
    void testInsertCategory() {
        // given
        Category category = new Category("관광지");

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertCategory(category)
        );
    }

    @DisplayName("파싱한 Category 정보가 이미 존재할 때 존재하는 City 정보를 반환해주는지 확인")
    @Test
    void testInsertCategoryResultWhenCategoryInfoIsDuplicate() {

        // given
        Category category = new Category("음식점");
        Category insertResult = dataService.insertCategory(category);

        // when
        Category duplicateResult = dataService.insertCategory(category);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 City 정보가 정상적으로 insert 되는지 확인")
    @Test
    void testInsertCity() {
        // given
        City city = new City("제주시");

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertCity(city)
        );
    }

    @DisplayName("파싱한 City 정보가 이미 존재할 때 존재하는 City 정보를 반환해주는지 확인")
    @Test
    void testInsertCityResultWhenCityInfoIsDuplicate() {

        // given
        City city = new City("제주시치");
        City insertResult = dataService.insertCity(city);

        // when
        City duplicateResult = dataService.insertCity(city);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 Dong 정보가 정상적으로 insert 되는지 확인")
    @Test
    void testInsertDong() {
        // given
        Dong dong = new Dong(11, "제주동");

        // when & then
        Assertions.assertDoesNotThrow(
                () -> dataService.insertDong(dong)
        );
    }

    @DisplayName("파싱한 Dong 정보가 이미 존재할 때 존재하는 Dong 정보를 반환해주는지 확인")
    @Test
    void testInsertDongResultWhenDongInfoIsDuplicate() {

        // given
        Dong dong = new Dong(11, "제주동");
        Dong insertResult = dataService.insertDong(dong);

        // when
        Dong duplicateResult = dataService.insertDong(dong);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

    @DisplayName("파싱한 TagList 정보가 정상적으로 insert 되는지 확인")
    @Test
    void testInsertTag() {
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
        Tag insertResult = dataService.insertTag(tagName);

        // when
        Tag duplicateResult = dataService.insertTag(tagName);

        // then
        Assertions.assertEquals(insertResult, duplicateResult);
    }

//    @DisplayName("태그 리스트들이 잘 출력되는 지 확인")
//    @Test
//    void testInsertTagList() {
//
//        // given
//        Place place = new Place( "제주",
//                new CategoryVO(1),
//                new CityVO(1),
//                new DongVO(1),
//                "아아",
//                "064-12312",
//                new CoordinateVO(33.33, 126.123),
//                "123142",
//                "여기",
//                "저기",
//                "이미지경로",
//                "썸네일경로",
//                0,
//                0
//        );
//        String placeInfo = "애월, 곽지, 서핑, 이색체험,실내,중,2~3시간";
//        String[] allTags = placeInfo.split("\\s*,\\s*");
//        List<String> tagList = Arrays.asList(allTags);
//
//        // when
//        List<Tag> insertTagResultList = tagList.stream().distinct().map(m -> dataService.insertTag(m)).collect(Collectors.toList());
//        // then
//        Assertions.assertDoesNotThrow(
//                () -> dataService.insertPlaceAndTags(new PlaceVO(place.getPlaceNo()), new TagVO( insertTagResultList.get(1).getTagNo()))
//        );
//
//    }

}
