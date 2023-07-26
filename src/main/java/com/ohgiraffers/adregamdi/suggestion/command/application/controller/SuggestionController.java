package com.ohgiraffers.adregamdi.suggestion.command.application.controller;


import com.ohgiraffers.adregamdi.suggestion.command.application.service.SuggestionCommandService;
import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/suggestion")
public class SuggestionController {

    private final SuggestionCommandService suggestionCommandService;

    @Autowired
    public SuggestionController(SuggestionCommandService suggestionCommandService){
        this.suggestionCommandService = suggestionCommandService;
    }


    @GetMapping
    public String goSuggestionPage(){

        return "/suggestionPage";
    }


    @PostMapping("/submitMessage")
    public String submitSuggestion(@RequestParam("suggestionMessage") String suggestionMessage,
                                   HttpSession session){



        Long userNo = ((UserDTO)session.getAttribute("loginUser")).getUserNo();

        suggestionCommandService.saveSuggestion(userNo, suggestionMessage);

        return "redirect:/suggestion";
    }

}
