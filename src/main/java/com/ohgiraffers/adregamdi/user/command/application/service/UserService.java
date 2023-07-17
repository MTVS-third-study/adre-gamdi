package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    @Autowired
    public UserService(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    // 닉네임 변경
    public UserDTO updateNickName(String nickName, UserDTO userInfo) throws Exception {
        userRepository.updateNickName(nickName, userInfo.getUserNo());
        return userDomainService.findByKakaoId(userInfo.getKakaoId());
    }

    // 회원 탈퇴
    public Long deleteUser(String id) {
        return userRepository.deleteByKakaoId(id);
    }
}