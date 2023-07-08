package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.service.OAuthService;
import com.ohgiraffers.adregamdi.user.command.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String kakaoCallback(@RequestParam String code) {
        int result = oAuthService.login(code);

        if (result == 1) {

            return "redirect:/";
        }

//        String token = oAuthService.getKakaoAccessToken(code); // access token 발급
//        oAuthService.getUserInfo(token); // 사용자 정보 조회
//        oAuthService.logout(token); // 로그아웃
        return "로그인 실패";
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