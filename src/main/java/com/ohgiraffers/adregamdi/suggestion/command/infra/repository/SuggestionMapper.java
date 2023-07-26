package com.ohgiraffers.adregamdi.suggestion.command.infra.repository;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuggestionMapper {

    void saveSuggestion(Long userNo, String suggestionMessage);

    void deleteSuggestion(Long suggestionNo);

}
