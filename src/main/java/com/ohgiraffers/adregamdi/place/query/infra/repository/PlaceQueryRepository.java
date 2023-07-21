package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceQueryRepository extends JpaRepository<Place, Long> {
}
