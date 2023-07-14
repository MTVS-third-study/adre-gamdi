package com.ohgiraffers.adregamdi.user.command.application.service;

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

//    public int login(UserDTO userInfo) {
//        UserDTO findUserInfo = userDomainService.findById(userInfo.getId());
//        if (userInfo == findUserInfo) {
//            return 1;
//        }
//        return userRepository.insertUser(userInfo);
//    }
}