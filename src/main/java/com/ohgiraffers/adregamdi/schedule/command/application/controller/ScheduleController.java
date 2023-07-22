package com.ohgiraffers.adregamdi.schedule.command.application.controller;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.command.application.service.ScheduleService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/schedule/*")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping("insertSchedule")
    public String insertSchedule(HttpSession session, ScheduleDTO scheduleDTO, Model model) {
        if (session.getAttribute("loginUser") == null){
            model.addAttribute("insertScheduleMessage", "로그인 후 이용해주세요");
            return "redirect:/schedule";
        }
        Long userNo = ((UserDTO)session.getAttribute("loginUser")).getUserNo();
        scheduleDTO.setUserNo(userNo);
        scheduleService.insertSchedule(scheduleDTO);
        return "redirect:/schedule";
    }

    @GetMapping("deleteSchedule")
    public String deleteSchedule(ScheduleDTO scheduleDTO) {
        try {
            scheduleService.deleteSchedule(scheduleDTO.getScheduleNo());
        } catch (Exception e){
            return e.getMessage();
        }
        return "";
    }

}
