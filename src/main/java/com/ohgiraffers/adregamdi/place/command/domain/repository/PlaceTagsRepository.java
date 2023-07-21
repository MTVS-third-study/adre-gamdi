package com.ohgiraffers.adregamdi.place.command.domain.repository;

import com.ohgiraffers.adregamdi.tagplace.command.domain.aggregate.entity.PlaceTags;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceTagsRepository extends JpaRepository<PlaceTags, Long> {

}