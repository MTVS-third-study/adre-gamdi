package com.ohgiraffers.adregamdi.schedule.query.application.controller;

import com.ohgiraffers.adregamdi.schedule.command.application.controller.ScheduleController;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.ScheduleQueryDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/schedule/query/*")
public class ScheduleQueryController {

    private final ScheduleQueryService scheduleQueryService;
    @Autowired
    public ScheduleQueryController(ScheduleQueryService scheduleQueryService) {
        this.scheduleQueryService = scheduleQueryService;
    }

    /* 설명. 내 일정 불러오기 */
    @GetMapping("mySchedule")
    public String loadMySchedule(HttpSession httpSession, Model model) {
        ScheduleQueryDTO scheduleQueryDTO = (ScheduleQueryDTO) httpSession.getAttribute("loginUser");
//        Long userNo = 1L;
        model.addAttribute("myScheduleList",scheduleQueryService.loadMyScheduleList(scheduleQueryDTO.getUserNo()));
        return "/scheduleResult";
    }


}
