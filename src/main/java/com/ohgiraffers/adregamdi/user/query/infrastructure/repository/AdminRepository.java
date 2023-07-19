package com.ohgiraffers.adregamdi.user.query.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AdminRepository {
    User save(User User);
    List<User> findAll();

}
