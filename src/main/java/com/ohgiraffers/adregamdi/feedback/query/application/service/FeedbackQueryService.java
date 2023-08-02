package com.ohgiraffers.adregamdi.feedback.query.application.service;

import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.entity.Feedback;
import com.ohgiraffers.adregamdi.feedback.query.application.dto.FeedbackDTO;
import com.ohgiraffers.adregamdi.feedback.query.infra.repository.FeedbackRepository;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity.Suggestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedbackQueryService {

    private FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackQueryService(FeedbackRepository feedbackRepository){
        this.feedbackRepository = feedbackRepository;
    }


    public List<FeedbackDTO> findAllFeedback(){
        List<Feedback> feedbackList = feedbackRepository.findAll();
        if (feedbackList == null){
            return new ArrayList<>();
        }
        List<FeedbackDTO> feedbackDTOList = new ArrayList<>();
        int num = feedbackList.size() - 1;
        for (int i = 0; i <= num; i++){
            feedbackDTOList.add(new FeedbackDTO(feedbackList.get(i).getFeedbackNo(),
                                                feedbackList.get(i).getUserNo().getUserNo(),
                                                feedbackList.get(i).getFeedbackMessage()));
        }
        return feedbackDTOList;
    }

}
