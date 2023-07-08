package com.ohgiraffers.adregamdi.user.command.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfraRepository implements UserRepository {
    @Override
    public int insertUser(UserDTO userInfo) {

        return 1;
    }

    @Override
    public User selectUserOne(int id) {

        return null;
    }

    @Override
    public void selectUserList() {

    }

    @Override
    public void updateUser() {

    }

    @Override
    public void deleteUser() {

    }
}
