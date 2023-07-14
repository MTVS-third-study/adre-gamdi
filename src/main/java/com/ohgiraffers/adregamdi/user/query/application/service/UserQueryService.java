package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.UserFindInfraRepository;
import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.UserQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryService {
    private final UserFindInfraRepository userFindInfraRepository;
    private final UserQueryRepository userFindRepository;

    @Autowired
    public UserQueryService(UserFindInfraRepository userFindInfraRepository, UserQueryRepository userFindRepository) {
        this.userFindInfraRepository = userFindInfraRepository;
        this.userFindRepository = userFindRepository;
    }

    public UserDTO findById(String id) { // 현재 유저 조회
//        User user = userFindRepository.findById(id);
        User user = userFindInfraRepository.findOneUser(id);
        return new UserDTO(
                user.getUserNo(),
                user.getId(),
                user.getKakaoNickName(),
                user.getServiceNickName(),
                user.getEmail(),
                user.getAge(),
                user.getGender(),
                user.getReport_count(),
                user.getReview_count(),
                user.getGrade(),
                user.isBlacklist_status());
    }
}




