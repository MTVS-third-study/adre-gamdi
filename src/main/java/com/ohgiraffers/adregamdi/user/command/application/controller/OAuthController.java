package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.service.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@AllArgsConstructor
@RequestMapping("/oauth")
public class OAuthController {
    private final OAuthService oAuthService;

    @Autowired
    public OAuthController(OAuthService oAuthService) {
        this.oAuthService = oAuthService;
    }

    // 카카오
    @ResponseBody
    @GetMapping("kakao")
    public String kakaoCallback(@RequestParam String code) {
        String token = oAuthService.getKakaoAccessToken(code); // access token 발급
        oAuthService.getUserInfo(token); // 사용자 정보 조회
        oAuthService.logout(token); // 로그아웃
        return "성공";
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