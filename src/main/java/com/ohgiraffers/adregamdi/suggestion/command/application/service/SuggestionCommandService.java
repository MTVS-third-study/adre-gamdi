package com.ohgiraffers.adregamdi.suggestion.command.application.service;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import com.ohgiraffers.adregamdi.suggestion.command.infra.repository.SuggestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionCommandService {

    private final SuggestionMapper suggestionMapper;

    @Autowired
    public SuggestionCommandService(SuggestionMapper suggestionMapper){

        this.suggestionMapper = suggestionMapper;

    }


    public void saveSuggestion(Long userNo, String suggestion){
        suggestionMapper.saveSuggestion(userNo, suggestion);
    }
    public void deleteSuggestion(Long suggestionNo){
        suggestionMapper.deleteSuggestion(suggestionNo);
    }


}
