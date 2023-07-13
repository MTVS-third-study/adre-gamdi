package com.ohgiraffers.adregamdi.user.command.infrastructure.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.service.KakaoDomainService;
import com.ohgiraffers.adregamdi.user.query.application.service.KakaoQueryService;
import org.springframework.stereotype.Service;

@Service
public class KakaoServiceImpl implements KakaoDomainService {
    private final KakaoQueryService kakaoQueryService;

    public KakaoServiceImpl(KakaoQueryService kakaoQueryService) {
        this.kakaoQueryService = kakaoQueryService;
    }

    public KakaoUserDTO getKakaoUserInfo(String code) {
        return kakaoQueryService.validateKakaoCertification(code);
    }
}
