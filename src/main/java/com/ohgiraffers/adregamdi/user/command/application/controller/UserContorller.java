package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserContorller {
    private final UserService userService;

    @Autowired
    public UserContorller(UserService userService) {
        this.userService = userService;
    }

}
