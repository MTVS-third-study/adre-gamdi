package com.ohgiraffers.adregamdi.category.query.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.domain.aggregate.entity.Category;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
class CategoryQueryServiceTest {

    @Autowired
    private CategoryQueryService categoryQueryService;

    @DisplayName("카테고리 조회 테스트")
    @Test
    void findCategoryByCategoryName() {

        // given
        String categoryName = "관광지";

        // when & then
        Assertions.assertDoesNotThrow(
                () -> categoryQueryService.findCategoryByCategoryName(categoryName)
        );
    }

    @DisplayName("카테고리 조회 실패 시 반환 값이 null인지 확인")
    @Test
    void testCheckNullFindCategoryResultWhenNoResult() {

        // given
        String categoryName = "소소소견";

        // when
        CategoryDTO result = categoryQueryService.findCategoryByCategoryName(categoryName);
        System.out.println("result = " + result);
        // then
        Assertions.assertNull(result);
    }

    @ParameterizedTest
    @ValueSource(ints = 4)
    void testFindCategory(int num){
        String categoryName = categoryQueryService.findCategoryNameByCategoryNo(num);
        System.out.println("categoryName = " + categoryName);
        Assertions.assertEquals(categoryName, "음식점");
    }

}