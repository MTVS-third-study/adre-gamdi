package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.KakaoDomainService;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;
    private final KakaoDomainService kakaoDomainService;

    @Autowired
    public UserService(UserRepository userRepository, UserDomainService userDomainService, KakaoDomainService kakaoDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
        this.kakaoDomainService = kakaoDomainService;
    }

    // 닉네임 변경
    public UserDTO updateNickName(String nickName, UserDTO userInfo) throws Exception {
        int result = userRepository.updateNickName(nickName, userInfo.getUserNo());

        if (result == 1) { // 닉네임 변경 성공 시
            return userDomainService.findByKakaoId(userInfo.getKakaoId());
        }
        return new UserDTO(); // 변경 실패 시
    }

    // 회원 탈퇴
    public int deleteUser(String token) {
        Long kakaoId = kakaoDomainService.unlinkKakao(token); // 카카오 연결끊기

        if (kakaoId != 0L) { // 카카오 연결끊기 성공 시
            Long result = userRepository.deleteByKakaoId(String.valueOf(kakaoId));

            if (result != 0L) { // DB에서 유저 정보 삭제 성공 시
                return 1;
            }
        }
        return 0; // 연결끊기, 유저 정보 삭제 실패 시
    }
}