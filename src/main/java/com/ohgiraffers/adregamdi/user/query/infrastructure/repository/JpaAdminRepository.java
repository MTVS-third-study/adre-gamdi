package com.ohgiraffers.adregamdi.user.query.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
@Repository
public class JpaAdminRepository implements AdminRepository{
    private final EntityManager em;



    public JpaAdminRepository(EntityManager em){
        this.em=em;

    }

    @Override
    @Transactional
    public User save(User user) {

        em.persist(user);
        em.flush();
        return user;
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("SELECT m FROM User m",User.class).getResultList();
    }
}
