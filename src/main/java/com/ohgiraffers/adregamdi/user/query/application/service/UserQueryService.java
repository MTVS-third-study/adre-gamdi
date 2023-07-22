package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {
    private final UserQueryRepository userQueryRepository;

    @Autowired
    public UserQueryService(UserQueryRepository userQueryRepository) {
        this.userQueryRepository = userQueryRepository;
    }

    public UserDTO findByKakaoId(String kakaoId) { // 현재 유저 조회
        User user = userQueryRepository.findByKakaoId(kakaoId);
        if (user == null) {
            return new UserDTO();
        }
        return new UserDTO(
                user.getUserNo(),
                user.getKakaoId(),
                user.getKakaoNickName(),
                user.getServiceNickName(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getReport_count(),
                user.getReview_count(),
                user.getGrade(),
                user.isBlacklist_status()
        );
    }

    public UserDTO findByUserNo(Long userNo) { // 유저 번호로 유저 조회
        User user = userQueryRepository.findByUserNo(userNo);
        if (user == null) {
            return new UserDTO();
        }
        return new UserDTO(
                user.getUserNo(),
                user.getKakaoId(),
                user.getKakaoNickName(),
                user.getServiceNickName(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getReport_count(),
                user.getReview_count(),
                user.getGrade(),
                user.isBlacklist_status()
        );
    }
}




