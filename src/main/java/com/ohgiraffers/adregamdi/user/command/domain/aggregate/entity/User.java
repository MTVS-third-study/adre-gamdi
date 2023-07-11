package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

//@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    //    @Column
    private String kakaoNickName;
    //    @Column
    private String serviceNickName;
    //    @Column
    private String email;
    //    @Column
    private String age;
    //    @Column
    private String gender;

    public User update(String id, String kakaoNickName, String serviceNickName, String email, String age, String gender) {
        this.id = id;
        this.kakaoNickName = kakaoNickName;
        this.serviceNickName = serviceNickName;
        this.email = email;
        this.age = age;
        this.gender = gender;
        return this;
    }

}
