package com.ohgiraffers.adregamdi.user.command.application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String id;
    private String nickname;
    private String email;
    private String gender;
}
