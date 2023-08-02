package com.ohgiraffers.adregamdi.user.command.application.dto;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.enumtype.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long userNo;
    private String kakaoId;
    private String kakaoProfileImage;
    private String kakaoNickName;
    private String serviceNickName;
    private String email;
    private String age;
    private String gender;
    private int report_count;
    private int review_count;
    private int grade;
    private boolean blacklist_status;
    private String access_Token;
    private String refresh_Token;
    private Role role;

    public UserDTO(Long userNo, String kakaoId, String kakaoProfileImage, String kakaoNickName, String serviceNickName, String email, String age, String gender, int report_count, int review_count, int grade, boolean blacklist_status, Role role) {
        this.userNo = userNo;
        this.kakaoId = kakaoId;
        this.kakaoProfileImage = kakaoProfileImage;
        this.kakaoNickName = kakaoNickName;
        this.serviceNickName = serviceNickName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.report_count = report_count;
        this.review_count = review_count;
        this.grade = grade;
        this.blacklist_status = blacklist_status;
        this.role = role;
    }
    public void setKakaoNickName(String kakaoNickName) {
        ByteBuffer buffer = StandardCharsets.UTF_8.encode(kakaoNickName);

        String utf8EncodedString = StandardCharsets.UTF_8.decode(buffer).toString();
        this.kakaoNickName = utf8EncodedString;
    }
}
