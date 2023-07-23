package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.enumtype.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED, force = true)
@Getter
@Table(name = "TBL_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private final Long userNo;
    @Column
    private final String kakaoId;
    @Column
    private final String kakaoProfileImage;
    @Column
    private final String kakaoNickName;
    @Column
    private final String serviceNickName;
    @Column
    private final String email;
    @Column
    private final String age;
    @Column
    private final String gender;
    @Column
    private final int report_count;
    @Column
    private final int review_count;
    @Column
    private final int grade;
    @Column
    private final boolean blacklist_status;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private final Role role;

    private User(Builder builder) {
        this.userNo = builder.userNo;
        this.kakaoProfileImage = builder.kakaoProfileImage;
        this.kakaoId = builder.kakaoId;
        this.kakaoNickName = builder.kakaoNickName;
        this.serviceNickName = builder.serviceNickName;
        this.email = builder.email;
        this.age = builder.age;
        this.gender = builder.gender;
        this.report_count = builder.report_count;
        this.review_count = builder.review_count;
        this.grade = builder.grade;
        this.blacklist_status = builder.blacklist_status;
        this.role = builder.role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public static class Builder {
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
        private Role role;

        public Builder userNo(Long userNo) {
            this.userNo = userNo;
            return this;
        }

        public Builder kakaoId(String kakaoId) {
            this.kakaoId = kakaoId;
            return this;
        }

        public Builder kakaoProfileImage(String kakaoProfileImage) {
            this.kakaoProfileImage = kakaoProfileImage;
            return this;
        }

        public Builder kakaoNickName(String kakaoNickName) {
            this.kakaoNickName = kakaoNickName;
            return this;
        }

        public Builder serviceNickName(String serviceNickName) {
            this.serviceNickName = serviceNickName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder age(String age) {
            this.age = age;
            return this;
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder report_count(int report_count) {
            this.report_count = report_count;
            return this;
        }

        public Builder review_count(int review_count) {
            this.review_count = review_count;
            return this;
        }

        public Builder grade(int grade) {
            this.grade = grade;
            return this;
        }

        public Builder blacklist_status(boolean blacklist_status) {
            this.blacklist_status = blacklist_status;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        // 대상 객체의 private 생성자를 호출하여 최종 인스턴스화 한다
        public User build() {
            return new User(this); // 빌더 객체 자신을 넘긴다.
        }
    }

}
