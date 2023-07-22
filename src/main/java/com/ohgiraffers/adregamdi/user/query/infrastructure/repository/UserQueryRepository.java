package com.ohgiraffers.adregamdi.user.query.infrastructure.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserQueryRepository extends JpaRepository<User, Long> {

    // 카카오 아이디로 유저 정보 조회
    User findByKakaoId(String kakaoId);

    User findByUserNo(Long userNo);
}

// 배치 프로그램..!