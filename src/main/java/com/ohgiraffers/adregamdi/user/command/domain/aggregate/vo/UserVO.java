package com.ohgiraffers.adregamdi.user.command.domain.aggregate.vo;

import lombok.Builder;
import lombok.EqualsAndHashCode;

@Builder
@EqualsAndHashCode
public class UserVO {
    private int id;
    private String nickname;
    private String email;
    private String gender;
}
