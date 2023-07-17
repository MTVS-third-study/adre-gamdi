package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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
    public String deleteUser(HttpSession session) {
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

    @PostMapping("updateNickName")
    public String updateNickName(HttpServletRequest request, HttpSession session) throws Exception {
        String nickName = request.getParameter("nickName");
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        session.setAttribute("loginUser", userService.updateNickName(nickName, loginUser));
        return "redirect:/myPage";
    }

}
