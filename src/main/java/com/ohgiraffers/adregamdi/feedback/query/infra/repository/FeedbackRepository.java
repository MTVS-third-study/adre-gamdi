package com.ohgiraffers.adregamdi.feedback.query.infra.repository;

import com.ohgiraffers.adregamdi.feedback.command.domain.aggregate.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

    List<Feedback> findAll();
}
