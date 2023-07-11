package com.ohgiraffers.adregamdi.user.command.domain.aggregate.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class UserVO {
    private String id;
    private String kakaoNickName;
    private String serviceNickName;
    private String email;
    private String age;
    private String gender;
}
