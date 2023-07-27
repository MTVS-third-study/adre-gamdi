package com.ohgiraffers.adregamdi.schedule.query.application.controller;

import com.ohgiraffers.adregamdi.schedule.query.application.dto.MyScheduleResponseDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/schedule/query/*")
public class ScheduleQueryController {

    private final ScheduleQueryService scheduleQueryService;
    @Autowired
    public ScheduleQueryController(ScheduleQueryService scheduleQueryService) {
        this.scheduleQueryService = scheduleQueryService;
    }

    /* 설명. 내 일정 불러오기 */
    @GetMapping("mySchedule")
    public ResponseEntity<MyScheduleResponseDTO> loadMySchedule(HttpSession session) {
        MyScheduleResponseDTO response = new MyScheduleResponseDTO();
        if (session.getAttribute("loginUser") == null) {
            response.setMessage("로그인 후 이용해주세요.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        Long userNo = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
        response.setMyScheduleList(scheduleQueryService.loadMyScheduleList(userNo));
        return ResponseEntity.ok(response);
    }
}