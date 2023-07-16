package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.OAuthService;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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

    // 카카오 로그인
    @GetMapping("kakao/login")
    public void kakaoCallback(@RequestParam String code, HttpSession session
            , HttpServletResponse response) throws IOException {
        UserDTO loginUser = oAuthService.kakaoLogin(code);
        session.setAttribute("kakaoToken", loginUser.getAccess_Token());
        session.setAttribute("loginUser", loginUser);
        UserDTO test = (UserDTO) session.getAttribute("loginUser");
        System.out.println("test = " + test.getId());
        System.out.println("test = " + test.getKakaoNickName());
        System.out.println("test = " + test.getServiceNickName());
        System.out.println("test = " + test.getEmail());
        System.out.println("test = " + test.getAge());
        System.out.println("test = " + test.getGender());
//        oAuthService.logout(loginUser.getAccess_Token()); // 로그아웃
//        session.removeAttribute("loginUser");

        response.sendRedirect("http://localhost:8080");
        response.sendRedirect("http://localhost:8080"); // 메인 페이지로
    }

    // 카카오 로그아웃
    @GetMapping("kakao/logout")
    public void kakaoLogout(HttpSession session, HttpServletResponse response) throws IOException {
        String token = (String) session.getAttribute("kakaoToken");
        oAuthService.kakaoLogout(token);
        session.removeAttribute("loginUser");
        response.sendRedirect("http://localhost:8080"); // 메인 페이지로
    }

//    // 네이버
//    @ResponseBody
//    @GetMapping("/naver")
//    public void naverCallback(@RequestParam String code) {
//        System.out.println(code);
//
//        System.out.println(oAuthService.getKakaoAccessToken(code));
//    }
}