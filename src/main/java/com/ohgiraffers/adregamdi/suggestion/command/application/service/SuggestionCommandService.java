package com.ohgiraffers.adregamdi.suggestion.command.application.service;



import com.ohgiraffers.adregamdi.suggestion.command.application.dto.SuggestionDTO;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import com.ohgiraffers.adregamdi.suggestion.command.infra.repository.SuggestionCommandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuggestionCommandService {

    private final SuggestionCommandRepository suggestionCommandRepository;

    @Autowired
    public SuggestionCommandService(SuggestionCommandRepository suggestionCommandRepository){
        this.suggestionCommandRepository = suggestionCommandRepository;

    }



    public void insertSuggestion(SuggestionDTO suggestionDTO){
        suggestionCommandRepository.save(
                new Suggestion(
                        new UserNo(suggestionDTO.getUserNo()),
                        suggestionDTO.getPlaceName(),
                        suggestionDTO.getPostCode(),
                        suggestionDTO.getRoadAddress(),
                        suggestionDTO.getAddress(),
                        suggestionDTO.getDetailAddress(),
                        suggestionDTO.getPhoneNumber(),
                        suggestionDTO.getSuggestionMessage()
                )
        );
    }
    public void deleteSuggestion(Long suggestionNo){
        suggestionCommandRepository.deleteSuggestionBySuggestionNo(suggestionNo);
    }


}
