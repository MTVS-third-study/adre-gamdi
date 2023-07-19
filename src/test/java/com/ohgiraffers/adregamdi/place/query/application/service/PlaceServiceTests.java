package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlaceServiceTests {

    @Autowired
    private PlaceService placeService;

    @ParameterizedTest
    @ValueSource(strings = {"연돈", "식당"})
    void testSearchByKeyword(String keyword) {

        Assertions.assertDoesNotThrow(
                () -> {
                    List<SearchPlace> places = placeService.findPlaceByKeyword(keyword);
                    places.forEach(System.out::println);
                }
        );

    }
}
