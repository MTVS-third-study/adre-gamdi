package com.ohgiraffers.adregamdi.user.command.domain.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    int insertUser(UserDTO userInfo);
//
//    void updateUser();
//
//    void deleteUser();
}