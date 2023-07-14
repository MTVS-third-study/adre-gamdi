package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.KakaoDomainService;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthService {
    private final UserDomainService userDomainService;
    private final KakaoDomainService kakaoDomainService;
    private final UserRepository userRepository;

    @Autowired
    public OAuthService(UserDomainService userDomainService, KakaoDomainService kakaoDomainService, UserRepository userRepository) {
        this.userDomainService = userDomainService;
        this.kakaoDomainService = kakaoDomainService;
        this.userRepository = userRepository;
    }

    public UserDTO kakaoLogin(String code) {
        KakaoUserDTO kakaoInfo = kakaoDomainService.getKakaoUserInfo(code); // 카카오
        return validateUser(kakaoInfo.getId());
    }

    public UserDTO validateUser(String id) {
        UserDTO findUserInfo = userDomainService.findById(id);
        if (findUserInfo == null) {
            userRepository.insertUser(findUserInfo);
        }
        return findUserInfo;
    }

    public void logout(String token) { // 로그아웃
        kakaoDomainService.logout(token);
    }
}
