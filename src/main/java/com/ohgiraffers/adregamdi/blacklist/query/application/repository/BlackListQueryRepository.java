package com.ohgiraffers.adregamdi.blacklist.query.application.repository;

import com.ohgiraffers.adregamdi.blacklist.domain.entity.BlackList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlackListQueryRepository extends JpaRepository<BlackList, Integer> {

    // query method
    BlackList findBlackListByBlackListNo(int no);

}
