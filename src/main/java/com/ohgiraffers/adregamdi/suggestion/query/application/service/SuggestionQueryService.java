package com.ohgiraffers.adregamdi.suggestion.query.application.service;

import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.query.infra.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionQueryService {

    private SuggestionRepository suggestionRepository;

    @Autowired
    public SuggestionQueryService(SuggestionRepository suggestionRepository){
        this.suggestionRepository = suggestionRepository;

    }

    public List<Suggestion> findAllSuggestion(){
        List<Suggestion> suggestionList = suggestionRepository.findAll();

        return suggestionList;
    }



}
