package com.ohgiraffers.adregamdi.user.command.domain.repository;

public interface UserRepository {
    void insertUser();

    void selectUserOne();

    void selectUserList();

    void updateUser();

    void deleteUser();
}
