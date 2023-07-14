package com.ohgiraffers.adregamdi.user.command.domain.repository;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    //    extends JpaRepository<User, Integer>
    int insertUser(UserDTO userInfo);

    void updateUser();

    void deleteUser();
}