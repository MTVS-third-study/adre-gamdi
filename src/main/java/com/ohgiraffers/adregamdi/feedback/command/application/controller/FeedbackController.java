package com.ohgiraffers.adregamdi.feedback.command.application.controller;

import com.ohgiraffers.adregamdi.feedback.command.application.service.FeedbackCommandService;
import com.ohgiraffers.adregamdi.feedback.query.application.dto.FeedbackDTO;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackCommandService feedbackCommandService;

    @Autowired
    public FeedbackController(FeedbackCommandService feedbackCommandService){
        this.feedbackCommandService = feedbackCommandService;
    }

    @PostMapping("/feedbackMessage")
    public String sendFeedback(@RequestParam("feedbackMessage")String feedbackMessage,
                               HttpSession session) {

        Long userNo = ((UserDTO)session.getAttribute("loginUser")).getUserNo();
        FeedbackDTO feedbackDTO = new FeedbackDTO(userNo, feedbackMessage);
        feedbackCommandService.insertFeedback(feedbackDTO);



        return "redirect:/";
    }

}
