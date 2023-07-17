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
//    private String access_Token;
//    private String refresh_Token;
}
