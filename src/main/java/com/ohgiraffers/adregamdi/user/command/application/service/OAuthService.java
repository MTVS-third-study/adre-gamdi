package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {
    private final UserDomainService userDomainService;
    private final UserRepository userRepository;

    @Autowired
    public OAuthService(UserDomainService userDomainService, UserRepository userRepository) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
    }

    public String getKakaoAccessToken(String code) {
        return userDomainService.getKakaoAccessToken(code); // 액세스 토큰 발행
    }

    public UserDTO getKakaoUserInfo(String token) {
        return userDomainService.getKakaoUserInfo(token); // 카카오로부터 유저 정보 조회
    }

    public void logout(String token) { // 로그아웃
        userDomainService.logout(token);
    }
}
