package com.ohgiraffers.adregamdi.user.command.domain.service;

import com.ohgiraffers.adregamdi.common.annotation.DomainService;
import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;

@DomainService
public interface KakaoDomainService {

    // 카카오 유저 정보 조회
    KakaoUserDTO getKakaoUserInfo(String code);

    // 카카오 로그아웃
    Long logout(String token);

    // 카카오 연결끊기
    Long unlinkKakao(String token);
}
