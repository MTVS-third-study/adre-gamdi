package com.ohgiraffers.adregamdi.place.query.infra.repository;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.PlaceTags;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceTagsQueryRepository extends JpaRepository<PlaceTags, Long> {

    @Modifying
    @Query(value = "SELECT TAG_NO" +
                   "  FROM TBL_PLACETAGS" +
                   " WHERE PLACE_NO = :placeNo", nativeQuery = true)
    List<Long> findAllByPlaceNo(@Param("placeNo") Long placeNo) throws Exception;
}
