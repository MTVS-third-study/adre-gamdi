package com.ohgiraffers.adregamdi.blacklist.infra.repository;

import com.ohgiraffers.adregamdi.blacklist.domain.entity.BlackList;
import com.ohgiraffers.adregamdi.blacklist.domain.repository.BlackListRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BlackListJPARepository implements BlackListRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void save(BlackList blackList) {
        manager.persist(blackList);
    }

}
