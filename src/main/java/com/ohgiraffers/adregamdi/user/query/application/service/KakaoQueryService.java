package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.TokenDTO;
import com.ohgiraffers.adregamdi.user.query.infrastructure.service.KakaoQueryInfraService;
import org.springframework.stereotype.Service;

@Service
public class KakaoQueryService {
    private final KakaoQueryInfraService kakaoQueryInfraService;

    public KakaoQueryService(KakaoQueryInfraService kakaoQueryInfraService) {
        this.kakaoQueryInfraService = kakaoQueryInfraService;
    }

    public KakaoUserDTO validateKakaoCertification(String code) {
        TokenDTO token = getKakaoAccessToken(code);
        return getKakaoUserInfo(token);
    }

    public TokenDTO getKakaoAccessToken(String code) {
        return kakaoQueryInfraService.getKakaoAccessToken(code);
    }

    public KakaoUserDTO getKakaoUserInfo(TokenDTO token) {
        return kakaoQueryInfraService.getKakaoUserInfo(token);
    }
}
