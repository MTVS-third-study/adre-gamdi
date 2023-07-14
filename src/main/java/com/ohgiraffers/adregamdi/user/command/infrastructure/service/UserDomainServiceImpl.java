package com.ohgiraffers.adregamdi.user.command.infrastructure.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainServiceImpl implements UserDomainService {
    private final UserQueryService userQueryService;

    @Autowired
    public UserDomainServiceImpl(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public UserDTO findById(String id) {
        return userQueryService.findById(id);
    }

}
