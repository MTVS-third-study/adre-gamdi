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

    public UserDTO findById(String id) { // 현재 유저 조회
        User user;
        try {
            user = userQueryRepository.findByKakaoId(id);
        } catch (NullPointerException ne) {
            ne.printStackTrace();
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




