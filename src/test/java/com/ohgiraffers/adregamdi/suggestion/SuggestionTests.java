package com.ohgiraffers.adregamdi.suggestion;


import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.suggestion.command.application.dto.SuggestionDTO;
import com.ohgiraffers.adregamdi.suggestion.command.application.service.SuggestionCommandService;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SuggestionTests {


    @Autowired
    private SuggestionCommandService suggestionCommandService;



    @DisplayName("insertSuggestion 생성 확인")
    @Test
    void testInsertScheduleService() {

        // given
        SuggestionDTO suggestion = new SuggestionDTO(
                1L,
                "나는 문어입니다"
        );


        // when & then
        Assertions.assertDoesNotThrow(
                () -> suggestionCommandService.insertSuggestion(suggestion)
        );

    }

}
