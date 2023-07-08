package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.OAuthService;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

//@AllArgsConstructor
@RestController
@RequestMapping("/oauth")
public class OAuthController {
    private final UserService userService;
    private final OAuthService oAuthService;

    @Autowired
    public OAuthController(UserService userService, OAuthService oAuthService) {
        this.userService = userService;
        this.oAuthService = oAuthService;
    }

    // 카카오
    @ResponseBody
    @GetMapping("kakao/login")
    public String kakaoCallback(@RequestParam String code, HttpSession session) {
        String token = oAuthService.getKakaoAccessToken(code);
        UserDTO loginUser = oAuthService.getKakaoUserInfo(token);
        int result = userService.login(loginUser);

        if (result == 1) {
            session.setAttribute("loginUser", loginUser);
            UserDTO test = (UserDTO) session.getAttribute("loginUser");
            System.out.println("test = " + test.getId());
            System.out.println("test = " + test.getNickname());
            System.out.println("test = " + test.getEmail());
            System.out.println("test = " + test.getGender());
            session.removeAttribute("loginUser");
            oAuthService.logout(token); // 로그아웃
            return "로그인 성공";
        }
        return "로그인 실패";
    }

//    @ResponseBody
//    @GetMapping("kakao/logout")
//    public

//    // 네이버
//    @ResponseBody
//    @GetMapping("/naver")
//    public void naverCallback(@RequestParam String code) {
//        System.out.println(code);
//
//        System.out.println(oAuthService.getKakaoAccessToken(code));
//    }


}