package com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "TBL_USER")
public class User {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userNo;
    @Column
    private String kakaoId;
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
}
