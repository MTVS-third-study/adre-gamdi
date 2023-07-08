package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDTO selectUserOne(int id) { // 현재 유저 조회
        User user = userRepository.selectUserOne(id);
        return new UserDTO(
                user.getId(),
                user.getNickname(),
                user.getEmail(),
                user.getGender());
    }
}