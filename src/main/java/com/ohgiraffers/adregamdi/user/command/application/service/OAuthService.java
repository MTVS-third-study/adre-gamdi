package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.enumtype.Role;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.KakaoDomainService;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
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

    // 카카오 로그인
    public UserDTO kakaoLogin(String code) {
        KakaoUserDTO kakaoInfo = kakaoDomainService.getKakaoUserInfo(code);
        return validateUser(kakaoInfo);
    }

    // 유저 유효성 검사
    private UserDTO validateUser(KakaoUserDTO kakaoInfo) {
        User userInfo;
        UserDTO findUserInfo = userDomainService.findByKakaoId(kakaoInfo.getKakaoId());

        if (findUserInfo.getUserNo() == null) { // 카카오에서 조회한 유저가 DB에 없다면 회원가입
            userInfo = userRepository.save(new User(
                    kakaoInfo.getKakaoId(),
                    kakaoInfo.getKakaoProfileImage(),
                    kakaoInfo.getKakaoNickName(),
                    "",
                    kakaoInfo.getEmail(),
                    kakaoInfo.getAge(),
                    kakaoInfo.getGender(),
                    0,
                    0,
                    1,
                    false,
                    Role.USER));
            findUserInfo.setUserNo(userInfo.getUserNo());
            findUserInfo.setKakaoId(userInfo.getKakaoId());
            findUserInfo.setKakaoProfileImage(userInfo.getKakaoProfileImage());
            findUserInfo.setKakaoNickName(userInfo.getKakaoNickName());
            findUserInfo.setServiceNickName(userInfo.getServiceNickName());
            findUserInfo.setEmail(userInfo.getEmail());
            findUserInfo.setAge(userInfo.getAge());
            findUserInfo.setGender(userInfo.getGender());
            findUserInfo.setReport_count(userInfo.getReport_count());
            findUserInfo.setReview_count(userInfo.getReview_count());
            findUserInfo.setGrade(userInfo.getGrade());
            findUserInfo.setBlacklist_status(userInfo.isBlacklist_status());
            findUserInfo.setRole(userInfo.getRole());
        }
        findUserInfo.setAccess_Token(kakaoInfo.getAccess_Token());
        findUserInfo.setRefresh_Token(kakaoInfo.getRefresh_Token());
        return findUserInfo;
    }

    // 카카오 로그아웃
    public Long kakaoLogout(String token) {
        return kakaoDomainService.logout(token);
    }
}
