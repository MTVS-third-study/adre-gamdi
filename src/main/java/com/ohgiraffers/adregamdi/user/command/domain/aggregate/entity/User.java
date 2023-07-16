package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "TBL_USER")
public class User {
    @Id
    @Column(name = "USER_NO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column(name = "ID")
    private String id;
    @Column(name = "KAKAO_NICKNAME")
    private String kakaoNickName;
    @Column(name = "SERVICE_NICKNAME")
    private String serviceNickName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "AGE")
    private String age;
    @Column(name = "GENDER")
    private String gender;
    @Column(name = "REPORT_COUNT")
    private int report_count;
    @Column(name = "REVIEW_COUNT")
    private int review_count;
    @Column(name = "GRADE")
    private int grade;
    @Column(name = "BLACKLIST_STATUS")
    private boolean blacklist_status;
    @Column(name = "ACCESS_TOKEN")
    private String access_Token;
    @Column(name = "REFRESH_TOKEN")
    private String refresh_Token;

//    public User update(String id, String kakaoNickName, String serviceNickName, String email, String age, String gender) {
//        this.id = id;
//        this.kakaoNickName = kakaoNickName;
//        this.serviceNickName = serviceNickName;
//        this.email = email;
//        this.age = age;
//        this.gender = gender;
//        return this;
//    }

}
