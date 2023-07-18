package com.ohgiraffers.adregamdi.place.command.domain.service;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class DataDomainServiceTest {

    private DataDomainService dataDomainService;
    @BeforeEach
    void setUp() {
        this.dataDomainService = new DataDomainService();
    }

    @DisplayName("태그 파싱 테스트 유효한지 테스트")
    @Test
    void testParseAllTagsWithValidCheck() {

        // given
        String allTags = "애월, 곽지, 서핑, 이색체험,실내,중,2~3시간, `애완동물, 6&6시간, ";
        JSONObject placeInfo = new JSONObject();
        placeInfo.put("alltag", allTags);

        // when
        List<String> result = dataDomainService.parseAllTagsWithValidCheck(placeInfo);
        List<String> expected = Arrays.asList("애월", "곽지", "서핑", "이색체험", "실내", "중", "2~3시간", "애완동물", "6&6시간");

        // then
        Assertions.assertEquals(expected, result);
    }
}