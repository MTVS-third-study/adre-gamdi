package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
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
        return validateUser(kakaoInfo);
    }

    private UserDTO validateUser(KakaoUserDTO kakaoInfo) {
        // 회원가입
        User userInfo = userRepository.save(new User(1L,
                kakaoInfo.getId(),
                kakaoInfo.getKakaoNickName(),
                "",
                kakaoInfo.getEmail(),
                kakaoInfo.getAge(),
                kakaoInfo.getGender(),
                0,
                0,
                1,
                false,
                kakaoInfo.getAccess_Token(),
                kakaoInfo.getRefresh_Token()));
        UserDTO findUserInfo = new UserDTO();
        findUserInfo.setUserNo(userInfo.getUserNo());
        findUserInfo.setId(userInfo.getId());
        findUserInfo.setKakaoNickName(userInfo.getKakaoNickName());
        findUserInfo.setServiceNickName(userInfo.getServiceNickName());
        findUserInfo.setEmail(userInfo.getEmail());
        findUserInfo.setAge(userInfo.getAge());
        findUserInfo.setGender(userInfo.getGender());
        findUserInfo.setReport_count(userInfo.getReport_count());
        findUserInfo.setReview_count(userInfo.getReview_count());
        findUserInfo.setGrade(userInfo.getGrade());
        findUserInfo.setBlacklist_status(userInfo.isBlacklist_status());
        findUserInfo.setAccess_Token(kakaoInfo.getAccess_Token());
        findUserInfo.setRefresh_Token(kakaoInfo.getRefresh_Token());
        return findUserInfo;
    }

    public void kakaoLogout(String token) { // 로그아웃
        kakaoDomainService.logout(token);
    }
}
