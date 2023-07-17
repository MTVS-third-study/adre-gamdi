package com.ohgiraffers.adregamdi.user.query.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserQueryRepository extends JpaRepository<User, Long> {
    User findByKakaoId(String kakaoId);
}
