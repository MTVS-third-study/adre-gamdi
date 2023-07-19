package com.ohgiraffers.adregamdi.blacklist.query.application.repository;

import com.ohgiraffers.adregamdi.blacklist.domain.entity.BlackList;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class JpaBlackQeuryRepository implements blackQeuryRepository{
    private final EntityManager em;
    public JpaBlackQeuryRepository(EntityManager em){
        this.em=em;
    }
    @Override
    public BlackList save(BlackList blackList) {
        em.persist(blackList);
        em.flush();
        return blackList;
    }

    @Override
    public List<BlackList> findBlackList() {
        return null;
    }
}
