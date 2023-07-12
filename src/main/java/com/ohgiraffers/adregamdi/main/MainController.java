package com.ohgiraffers.adregamdi.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/*")
public class MainController {

    @GetMapping(value = {"/", "/main"})
    public String goMain() {
        return "main";
    }

    @GetMapping("login")
    public String login() {
        return "kakao/loginForm";
    }

//    @GetMapping("logout")
//    public String logout(HttpSession session) {
//        String token = (String) session.getAttribute("kakaoToken");
//        if () {
//            return "kakao/logout";
//        }
//        return "naver/logout";
//    }

    @GetMapping("schedule")
    public String goSchedule() {
        return "schedule";
    }


}
