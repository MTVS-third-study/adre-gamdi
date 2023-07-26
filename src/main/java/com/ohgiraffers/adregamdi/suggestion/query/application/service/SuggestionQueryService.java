package com.ohgiraffers.adregamdi.suggestion.query.application.service;

import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.query.infra.repository.SuggestionQueryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionQueryService {

    private final SuggestionQueryMapper suggestionQueryMapper;

    @Autowired
    public SuggestionQueryService(SuggestionQueryMapper suggestionQueryMapper){

        this.suggestionQueryMapper = suggestionQueryMapper;
    }

    public List<Suggestion> findAllSuggestion(){
        return suggestionQueryMapper.findAllSuggestion();
    }
}
