package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("deleteForm")
    public String goDeleteUser() {
        return "user/deleteForm";
    }

    @PostMapping("deleteUser")
    public String deleteUser(HttpSession session, ModelAndView mv) {
        Long result = userService.deleteUser(((UserDTO) session.getAttribute("loginUser")).getKakaoId());
        System.out.println("result = " + result);
        session.removeAttribute("loginUser");
        session.removeAttribute("service");
        return "redirect:/";
    }

    @PostMapping("deleteNo")
    public String deleteNo() {
        return "redirect:/myPage";
    }

}
