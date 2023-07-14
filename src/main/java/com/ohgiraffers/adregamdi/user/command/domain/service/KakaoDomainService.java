package com.ohgiraffers.adregamdi.user.command.domain.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;

public interface KakaoDomainService {
    KakaoUserDTO getKakaoUserInfo(String code);

    void logout(String token);
}
