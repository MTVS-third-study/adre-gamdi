package com.ohgiraffers.adregamdi.user.query.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserFindInfraRepository {
    public User findOneUser(String id) {

        return User.builder()
                .id("1")
                .kakaoNickName("qwe")
                .serviceNickName("asd")
                .email("qwe@ffsd")
                .age("222")
                .gender("q")
                .build();
    }
}
