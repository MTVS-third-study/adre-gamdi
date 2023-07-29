package com.ohgiraffers.adregamdi.feedback.command.infra.repository;

import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackCommandRepository extends JpaRepository<Feedback,Integer> {
    void deleteFeedbackByFeedbackNo(Long feedbackNo);
}
