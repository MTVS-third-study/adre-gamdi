package com.ohgiraffers.adregamdi.user.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class KakaoUserDTO {
    private String kakaoId;
    private String kakaoProfileImage;
    private String kakaoNickName;
    private String email;
    private String age;
    private String gender;
    private String access_Token;
    private String refresh_Token;

    public void setKakaoNickName(String kakaoNickName) {
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(kakaoNickName);

        String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
        this.kakaoNickName = utf8EncodedString;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public void setKakaoProfileImage(String kakaoProfileImage) {
        this.kakaoProfileImage = kakaoProfileImage;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAccess_Token(String access_Token) {
        this.access_Token = access_Token;
    }

    public void setRefresh_Token(String refresh_Token) {
        this.refresh_Token = refresh_Token;
    }
}
