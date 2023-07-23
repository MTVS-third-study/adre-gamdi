package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.enumtype.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "TBL_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column
    private String kakaoId;
    @Column
    private String kakaoProfileImage;
    @Column
    private String kakaoNickName;
    @Column
    private String serviceNickName;
    @Column
    private String email;
    @Column
    private String age;
    @Column
    private String gender;
    @Column
    private int report_count;
    @Column
    private int review_count;
    @Column
    private int grade;
    @Column
    private boolean blacklist_status;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public User(String kakaoId, String kakaoProfileImage, String kakaoNickName, String serviceNickName, String email, String age, String gender, int report_count, int review_count, int grade, boolean blacklist_status, Role role) {
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
        this.role = Role.USER;
    }

    public User(Long userNo, String kakaoProfileImage, String kakaoId, String kakaoNickName, String serviceNickName, String email, String age, String gender, int report_count, int review_count, int grade, boolean blacklist_status, Role role) {
        this.userNo = userNo;
        this.kakaoProfileImage = kakaoProfileImage;
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
        this.role = role;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public void setKakaoProfileImage(String kakaoProfileImage) {
        this.kakaoProfileImage = kakaoProfileImage;
    }

    public void setKakaoNickName(String kakaoNickName) {
        this.kakaoNickName = kakaoNickName;
    }

    public void setServiceNickName(String serviceNickName) {
        this.serviceNickName = serviceNickName;
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

    public void setReport_count(int report_count) {
        this.report_count = report_count;
    }

    public void setReview_count(int review_count) {
        this.review_count = review_count;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setBlacklist_status(boolean blacklist_status) {
        this.blacklist_status = blacklist_status;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

}
