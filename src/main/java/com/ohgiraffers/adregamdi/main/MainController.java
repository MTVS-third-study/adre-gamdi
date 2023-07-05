package com.ohgiraffers.adregamdi.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;

@Controller
@RequestMapping("/*")
public class MainController {

    @GetMapping(value = {"/","/main"})
    public String goMain(){
        return "main";
    }

    @GetMapping("schedule")
    public String goSchedule(){
        return "schedule";
    }

}
