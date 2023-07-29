package com.ohgiraffers.adregamdi.feedback.command.application.service;


import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.entity.Feedback;
import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.vo.UserNo;
import com.ohgiraffers.adregamdi.feedback.command.infra.repository.FeedbackCommandRepository;
import com.ohgiraffers.adregamdi.feedback.query.application.dto.FeedbackDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeedbackCommandService {

    private final FeedbackCommandRepository feedbackCommandRepository;

    @Autowired
    public FeedbackCommandService(FeedbackCommandRepository feedbackCommandRepository){
        this.feedbackCommandRepository = feedbackCommandRepository;
    }

    public void insertFeedback(FeedbackDTO feedbackDTO){
        feedbackCommandRepository.save(
                new Feedback(
                        new UserNo(feedbackDTO.getUserNo()),
                        feedbackDTO.getFeedbackMessage()
                )
        );
    }
    public void deleteFeedback(Long feedbackNo){
        feedbackCommandRepository.deleteFeedbackByFeedbackNo(feedbackNo);
    }

}
