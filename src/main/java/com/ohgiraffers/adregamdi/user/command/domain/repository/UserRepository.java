package com.ohgiraffers.adregamdi.user.command.domain.repository;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    int insertUser(UserDTO userInfo);

    User selectUserOne(int id);

    void selectUserList();

    void updateUser();

    void deleteUser();
}