package com.ohgiraffers.adregamdi.place.command.domain.repository;

import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}
