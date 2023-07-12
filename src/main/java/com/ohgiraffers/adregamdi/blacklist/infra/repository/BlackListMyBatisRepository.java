package com.ohgiraffers.adregamdi.blacklist.infra.repository;

import com.ohgiraffers.adregamdi.blacklist.domain.entity.BlackList;
import com.ohgiraffers.adregamdi.blacklist.domain.repository.BlackListRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;

@Repository
@Primary
public class BlackListMyBatisRepository implements BlackListRepository {
    @Override
    public void save(BlackList blackList) {

    }
}
