package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagQueryRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);
}
