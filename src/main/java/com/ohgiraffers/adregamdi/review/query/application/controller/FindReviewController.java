package com.ohgiraffers.adregamdi.review.query.application.controller;

import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;

@Controller
public class FindReviewController {
    private UserRepository userRepository;

    @Autowired
    public FindReviewController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




}
