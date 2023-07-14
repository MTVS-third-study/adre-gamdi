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
    //    @Column(name="USER_NO")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNo;
    //    @Column
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
    //    @Column
    private int report_count;
    //    @Column
    private int review_count;
    //    @Column
    private int grade;
    //    @Column
    private boolean blacklist_status;
    
}
