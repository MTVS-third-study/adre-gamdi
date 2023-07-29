package com.ohgiraffers.adregamdi.feedback.query.application.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FeedbackDTO {

    private Long feedbackNo;

    private Long userNo;

    private String feedbackMessage;

    public FeedbackDTO(Long userNo, String feedbackMessage) {
        this.userNo = userNo;
        this.feedbackMessage = feedbackMessage;
    }
}
