package com.ohgiraffers.adregamdi.user.command.domain.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserDomainService {
    // https://kauth.kakao.com/oauth/logout?client_id=dd52d3a258bf3ccbc37de832dfecd0d4&logout_redirect_uri=http://localhost:8080/oauth/kakao/logout
    String getKakaoAccessToken(String code);

    UserDTO getKakaoUserInfo(String token);

    void logout(String token);

    UserDTO findOneUser(String id);
}
