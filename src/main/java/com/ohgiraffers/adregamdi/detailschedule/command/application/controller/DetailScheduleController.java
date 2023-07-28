package com.ohgiraffers.adregamdi.detailschedule.command.application.controller;

import com.ohgiraffers.adregamdi.detailschedule.command.application.service.DetailScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detailSchedule")
public class DetailScheduleController {
    private final DetailScheduleService detailScheduleService;

    @Autowired
    public DetailScheduleController(DetailScheduleService detailScheduleService) {
        this.detailScheduleService = detailScheduleService;
    }

//    // 세부 일정 등록
//    @GetMapping("regist")
//    public void registDetailSchedule(@RequestParam("travelDays") String travelDay) {
//        DetailScheduleDTO  = new
//
//        List<DetailScheduleDTO> getList = new ArrayList<>();
//        List<DetailScheduleDTO> detailScheduleList;
//
//        for (int i = 0; i < getList.size(); i++) {
//            getList.add(i, new DetailScheduleDTO(
//                    1L
//                    , 1
//                    , 1
//                    , new TotalScheduleNo(1)
//                    , new PlaceNo(1)));
//        }
//        detailScheduleList = detailScheduleService.registDetailSchedule(getList);
//
//        for (DetailScheduleDTO detailScheduleDTO : detailScheduleList) {
//            System.out.println("detailScheduleList = " + detailScheduleDTO);
//        }
//    }
}
