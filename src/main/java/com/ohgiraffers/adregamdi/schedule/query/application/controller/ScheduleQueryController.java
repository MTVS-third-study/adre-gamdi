package com.ohgiraffers.adregamdi.schedule.query.application.controller;

import com.ohgiraffers.adregamdi.schedule.command.application.controller.ScheduleController;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.ScheduleQueryDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @GetMapping("mySchedule")
    public void loadMySchedule(HttpSession httpSession) {
        Long userNo = (Long) httpSession.getAttribute("userNo");
        scheduleQueryService.loadMyScheduleList(userNo);
    }


}
