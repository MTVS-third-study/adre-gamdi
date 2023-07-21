package com.ohgiraffers.adregamdi.user.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long userNo;
    private String kakaoId;
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

    public UserDTO(Long userNo, String kakaoId, String kakaoNickName, String serviceNickName, String email, String age, String gender, int report_count, int review_count, int grade, boolean blacklist_status) {
        this.userNo = userNo;
        this.kakaoId = kakaoId;
        this.kakaoNickName = kakaoNickName;
        this.serviceNickName = serviceNickName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.report_count = report_count;
        this.review_count = review_count;
        this.grade = grade;
        this.blacklist_status = blacklist_status;
    }
}
