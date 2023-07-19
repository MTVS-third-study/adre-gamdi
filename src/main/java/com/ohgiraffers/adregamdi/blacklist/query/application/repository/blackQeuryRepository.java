package com.ohgiraffers.adregamdi.blacklist.query.application.repository;

import com.ohgiraffers.adregamdi.blacklist.domain.entity.BlackList;

import java.util.List;

public interface blackQeuryRepository {
    BlackList save(BlackList blackList);

    List<BlackList> findBlackList();
}
