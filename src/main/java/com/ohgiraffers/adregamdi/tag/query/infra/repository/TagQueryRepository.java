package com.ohgiraffers.adregamdi.tag.query.infra.repository;

import com.ohgiraffers.adregamdi.tag.command.domain.aggregate.entity.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TagQueryRepository extends JpaRepository<Tag, Long> {
    Tag findByTagName(String tagName);

    @Query(value = "SELECT TAG_NAME" +
                   "  FROM TBL_TAG " +
                   " WHERE TAG_NO = :tagNo", nativeQuery = true)
    String findTagNameByTagNo(@Param("tagNo") Long tagNo);

    Long countTagByTagName(String tagName);
}
