package com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.entity;

import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.vo.UserNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TBL_FEEDBACK")
public class Feedback {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedbackNo;

    @Embedded
    private UserNo userNo;

    @Column
    private String feedbackMessage;

    public Feedback(UserNo userNo, String feedbackMessage) {
        this.userNo = userNo;
        this.feedbackMessage = feedbackMessage;
    }
}
