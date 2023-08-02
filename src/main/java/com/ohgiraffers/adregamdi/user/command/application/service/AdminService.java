package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminService {
    private final UserRepository userRepository;
    private final UserDomainService userDomainService;

    @Autowired
    public AdminService(UserRepository userRepository, UserDomainService userDomainService) {
        this.userRepository = userRepository;
        this.userDomainService = userDomainService;
    }

    // 회원 등급 변경
    public UserDTO updateGrade(int grade, UserDTO userInfo) throws Exception {
        int result = userRepository.updateGrade(grade, userInfo.getUserNo());

        if (result == 1) { // 등급 변경 성공 시
            return userDomainService.findByKakaoId(userInfo.getKakaoId());
        }
        return new UserDTO(); // 변경 실패 시
    }
}

