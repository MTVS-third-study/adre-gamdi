package com.ohgiraffers.adregamdi.schedule.query.application.controller;

import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@RestController
@RestController
@RequestMapping("/schedule/query/*")
public class ScheduleQueryController {

    private final ScheduleQueryService scheduleQueryService;
    @Autowired
    public ScheduleQueryController(ScheduleQueryService scheduleQueryService) {
        this.scheduleQueryService = scheduleQueryService;
    }

    /* 설명. 내 일정 불러오기 */
    @ResponseBody
    @GetMapping("mySchedule")
    public Map<String, List<ScheduleDTO>> loadMySchedule(HttpSession session) {
//        if (session.getAttribute("loginUser") == null) {
//            model.addAttribute("myScheduleMessage", "로그인 후 이용해주세요.");
//            return "redirect:/schedule";
//        }
        Long userNo = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
       List<ScheduleDTO> myScheduleList= scheduleQueryService.loadMyScheduleList(userNo);
       Map<String,List<ScheduleDTO>> respMyScheduleList=new HashMap<>();
       respMyScheduleList.put("myScheduleList",myScheduleList);
        return respMyScheduleList;
    }


}
