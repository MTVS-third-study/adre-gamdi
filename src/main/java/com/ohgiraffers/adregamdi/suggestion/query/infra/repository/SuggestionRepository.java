package com.ohgiraffers.adregamdi.suggestion.query.infra.repository;

import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SuggestionRepository extends JpaRepository<Suggestion, Integer> {

    List<Suggestion> findAll();


}
