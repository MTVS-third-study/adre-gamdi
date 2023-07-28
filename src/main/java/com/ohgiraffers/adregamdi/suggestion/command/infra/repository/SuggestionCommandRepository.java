package com.ohgiraffers.adregamdi.suggestion.command.infra.repository;

import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionCommandRepository extends JpaRepository<Suggestion, Integer> {

    void deleteSuggestionBySuggestionNo(Long suggestionNo);

}
