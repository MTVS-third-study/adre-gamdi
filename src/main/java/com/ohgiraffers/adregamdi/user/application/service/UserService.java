package com.ohgiraffers.adregamdi.user.application.service;

import com.ohgiraffers.adregamdi.user.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.domain.service.UserDomainService;
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
}
