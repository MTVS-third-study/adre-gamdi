package com.ohgiraffers.adregamdi.user.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class KakaoUserDTO {
    private String id;
    private String kakaoNickName;
    private String email;
    private String age;
    private String gender;
    private String access_Token;
    private String refresh_Token;
}
