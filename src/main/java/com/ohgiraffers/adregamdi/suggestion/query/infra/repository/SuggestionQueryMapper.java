package com.ohgiraffers.adregamdi.suggestion.query.infra.repository;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SuggestionQueryMapper {
    List<Suggestion> findAllSuggestion();
}
