package com.ohgiraffers.adregamdi.blacklist.domain.entity;

import org.springframework.stereotype.Controller;

//import javax.persistence.*;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "TBL_BLACKLIST")
public class BlackList {

//    @Id
//    @Column(name = "BLACKLIST_NO")
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // 필기. AUTO_INCREMENT
    private int blackListNo;

//    @Embedded
    private BlackListMemberNo blackListMemberNo;

//    @Embedded
    private BlackListDate blackListDate;

}
