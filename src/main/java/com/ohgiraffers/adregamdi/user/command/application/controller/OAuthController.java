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
        session.setAttribute("service", "kakao");
        session.setAttribute("loginUser", oAuthService.kakaoLogin(code));
        response.sendRedirect("http://localhost:8080"); // 메인 페이지로
    }

    // 카카오 로그아웃
    @GetMapping("kakao/logout")
    public void kakaoLogout(HttpSession session, HttpServletResponse response) throws IOException {
        String token = ((UserDTO) session.getAttribute("loginUser")).getAccess_Token();
        Long result = oAuthService.kakaoLogout(token);

        if (result != 0L) { // 카카오 로그아웃 성공 시
            session.removeAttribute("loginUser");
            session.removeAttribute("service");
            response.sendRedirect("http://localhost:8080"); // 메인 페이지로
        } else {
            response.sendRedirect("errorPage"); // 로그아웃 실패 시 에러 페이지로
        }
    }

//    // 네이버 로그인
//    @GetMapping("/naver")
//    public void naverCallback(@RequestParam String code) {
//        System.out.println(code);
//
//        System.out.println(oAuthService.getKakaoAccessToken(code));
//    }

}