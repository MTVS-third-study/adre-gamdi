package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller

public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 닉네임 변경
    @PostMapping("user/updateNickName")
    public String updateNickName(@RequestParam("nickName") String nickName, HttpSession session) throws Exception {
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        session.setAttribute("loginUser", userService.updateNickName(nickName, loginUser));
        System.out.println(nickName) ;
        return "redirect:/myPage";
    }

    // 회원탈퇴 페이지로 이동
    @GetMapping("user/deleteForm")
    public String goDeleteUser() {
        return "user/deleteForm";
    }

    // 회원탈퇴 예
    @PostMapping("user/deleteUser")
    public String deleteUser(HttpSession session) {
        String token = ((UserDTO) session.getAttribute("loginUser")).getAccess_Token();
        int result = userService.deleteUser(token);

        if (result == 1) { // 탈퇴 성공
            session.removeAttribute("loginUser");
            session.removeAttribute("service");
            return "redirect:/main";
        }
        return "errorPage"; // 탈퇴 실패 시 에러페이지로
    }

    // 회원탈퇴 아니오
    @PostMapping("user/deleteNo")
    public String deleteNo() {
        return "redirect:/myPage";
    }


}
