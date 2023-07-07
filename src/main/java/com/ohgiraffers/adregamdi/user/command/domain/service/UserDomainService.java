package com.ohgiraffers.adregamdi.user.command.domain.service;

import com.ohgiraffers.adregamdi.user.command.infrastructure.service.UserInfraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserDomainService {
    private final UserInfraService userInfraService;

    @Autowired
    public UserDomainService(UserInfraService userInfraService) {
        this.userInfraService = userInfraService;
    }

    public String getKakaoAccessToken(String code) {
        return userInfraService.getKakaoAccessToken(code);
    }

    public Map<String, Object> getUserInfo(String token) {
        return userInfraService.getUserInfo(token);
    }
}
