package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.UserFindInfraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserFindService {
    private final UserFindInfraRepository userFindInfraRepository;

    @Autowired
    public UserFindService(UserFindInfraRepository userFindInfraRepository) {
        this.userFindInfraRepository = userFindInfraRepository;
    }

    public UserDTO findOneUser(String id) { // 현재 유저 조회
        User user = userFindInfraRepository.findOneUser(id);
        return new UserDTO(
                user.getId(),
                user.getKakaoNickName(),
                user.getServiceNickName(),
                user.getEmail(),
                user.getAge(),
                user.getGender());
    }
}




