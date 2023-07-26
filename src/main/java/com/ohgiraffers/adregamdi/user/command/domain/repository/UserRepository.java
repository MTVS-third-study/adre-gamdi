package com.ohgiraffers.adregamdi.user.command.domain.repository;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    // 닉네임 변경
    @Modifying
    @Query(value = " UPDATE TBL_USER "
            + " SET SERVICE_NICK_NAME = :nickName "
            + " WHERE USER_NO = :userNo", nativeQuery = true)
    int updateNickName(@Param("nickName") String nickName, @Param("userNo") Long userNo) throws Exception;

    // 카카오 아이디로 유저 삭제
    Long deleteByKakaoId(String id);

    // 회원 등급 변경
    @Modifying
    @Query(value = "UPDATE TBL_USER"
            + " SET GRADE = :grade "
            + " WHERE USER_NO = :userNo", nativeQuery = true)
    int updateGrade(@Param("grade") int grade, @Param("userNo") Long userNo) throws Exception;
}