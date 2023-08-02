package com.ohgiraffers.adregamdi.schedule.query.application.controller;

import com.ohgiraffers.adregamdi.detailschedule.command.application.dto.DetailScheduleDTO;
import com.ohgiraffers.adregamdi.detailschedule.query.application.service.DetailScheduleQueryService;
import com.ohgiraffers.adregamdi.schedule.command.application.dto.ScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.DetailScheduleAndPlaceDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.LoadMyScheduleDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.dto.MyScheduleResponseDTO;
import com.ohgiraffers.adregamdi.schedule.query.application.service.ScheduleQueryService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.*;
import java.util.stream.Collectors;

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
    public ResponseEntity<MyScheduleResponseDTO> loadMyScheduleList(HttpSession session) {
        MyScheduleResponseDTO response = new MyScheduleResponseDTO();
        if (session.getAttribute("loginUser") == null) {
            response.setMessage("로그인 후 이용해주세요.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        Long userNo = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
        response.setMyScheduleList(scheduleQueryService.loadMyScheduleList(userNo));
        return ResponseEntity.ok(response);
    }

    @GetMapping("loadMySchedule")
    public ResponseEntity<LoadMyScheduleDTO> loadMyScheduleAndDetailSchedule(
            @RequestParam("scheduleNo") Long scheduleNo) {
        if (scheduleNo == null) {
            LoadMyScheduleDTO response = new LoadMyScheduleDTO("일정 번호가 없는 것으로 조회됩니다.");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
        ScheduleDTO mySchedule = scheduleQueryService.loadMySchedule(scheduleNo);
        List<DetailScheduleAndPlaceDTO> myDetailScheduleList = scheduleQueryService.loadMyDetailScheduleList(scheduleNo);
        Map<String, List<DetailScheduleAndPlaceDTO>> myDetailScheduleObject = new HashMap<>();
        int dayAndNight = Integer.parseInt(mySchedule.getDayAndNight());
        for (int index=1; index<=dayAndNight; index++){
            int finalIndex = index;
            List<DetailScheduleAndPlaceDTO> detailScheduleListByday = myDetailScheduleList.stream()
                    .filter(detailScheduleAndPlaceDTO ->
                            detailScheduleAndPlaceDTO.getDetailScheduleDTO().getScheduleDay()== finalIndex)
                    .collect(Collectors.toList());
            Collections.sort(detailScheduleListByday, new Comparator<DetailScheduleAndPlaceDTO>() {
                @Override
                public int compare(DetailScheduleAndPlaceDTO o1, DetailScheduleAndPlaceDTO o2) {
                    return o1.getDetailScheduleDTO().getProcedureNo() - o2.getDetailScheduleDTO().getProcedureNo();
                }
            });
            myDetailScheduleObject.put(""+index, detailScheduleListByday);
        }

        LoadMyScheduleDTO response = new LoadMyScheduleDTO(
                mySchedule.getScheduleNo(),
                mySchedule.getScheduleName(),
                mySchedule.getStartDate(),
                mySchedule.getEndDate(),
                mySchedule.getDayAndNight(),
                myDetailScheduleObject
        );

        return ResponseEntity.ok(response);
    }


}