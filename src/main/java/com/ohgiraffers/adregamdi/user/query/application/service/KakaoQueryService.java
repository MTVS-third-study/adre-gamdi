package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.TokenDTO;
import com.ohgiraffers.adregamdi.user.query.infrastructure.service.KakaoQueryInfraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KakaoQueryService {
    private final KakaoQueryInfraService kakaoQueryInfraService;

    @Autowired
    public KakaoQueryService(KakaoQueryInfraService kakaoQueryInfraService) {
        this.kakaoQueryInfraService = kakaoQueryInfraService;
    }

    // 카카오 인증 유효성 검사
    public KakaoUserDTO validateKakaoCertification(String code) {
        TokenDTO token = getKakaoAccessToken(code);
        return getKakaoUserInfo(token);
    }

    // 카카오 액세스 토큰 발급
    private TokenDTO getKakaoAccessToken(String code) {
        return kakaoQueryInfraService.getKakaoAccessToken(code);
    }

    // 카카오 유저 정보 조회
    private KakaoUserDTO getKakaoUserInfo(TokenDTO token) {
        return kakaoQueryInfraService.getKakaoUserInfo(token);
    }
}
