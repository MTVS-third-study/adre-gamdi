package com.ohgiraffers.adregamdi.user.command.domain.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserDomainService {

    UserDTO findById(String id);
}
