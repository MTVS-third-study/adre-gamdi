package com.ohgiraffers.adregamdi.place.query.domain.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CategoryQueryServiceTests {

    @Autowired
    private CategoryQueryService categoryQueryService;

    @ParameterizedTest
    @ValueSource(ints = 4)
    void testFindCategory(int num){
        String categoryName = categoryQueryService.findCategoryNameByCategoryNo(num);
        System.out.println("categoryName = " + categoryName);
        Assertions.assertEquals(categoryName, "음식점");
    }
}
