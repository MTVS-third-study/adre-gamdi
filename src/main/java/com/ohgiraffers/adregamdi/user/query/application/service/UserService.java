package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.UserInfraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserInfraRepository userInfraRepository;
    
    @Autowired
    public UserService(UserInfraRepository userInfraRepository) {
        this.userInfraRepository = userInfraRepository;
    }


}
