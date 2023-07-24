package com.ohgiraffers.adregamdi.place.query.application.controller;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.query.application.dto.ResponsePlaceDTO;
import com.ohgiraffers.adregamdi.place.query.application.service.PlaceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@Controller
@RequestMapping("/placeQuery")
public class PlaceQueryController {

    private final PlaceQueryService placeQueryService;
    @Autowired
    public PlaceQueryController(PlaceQueryService placeQueryService){
        this.placeQueryService = placeQueryService;
    }
    @ResponseBody
    @GetMapping("/searchPlace")
    public  Map<String,List<PlaceDTO>> searchPlace(@RequestParam("searchKeyword") String keyword){
        keyword = keyword.replaceAll("\"", "");
        List<PlaceDTO> placeList = placeQueryService.findPlaceByKeyword(keyword);

     Map<String,List<PlaceDTO>> responsePlaceList=new HashMap<>();
     responsePlaceList.put("respPlaceList",placeList);
        System.out.println("keyword = " + keyword);
        placeList.forEach(System.out::println);
        return responsePlaceList;
    }

    @ResponseBody
    @GetMapping("/placeInfo")
    public Map<String,ResponsePlaceDTO> placeInfo(@RequestParam("placeNo") Long placeNo) {
        ResponsePlaceDTO placeInfo = placeQueryService.findPlaceWithTagsByPlaceNo(placeNo);
        Map<String,ResponsePlaceDTO> responsePlaceInfo =new HashMap<>();
        responsePlaceInfo.put("detailPlaceInfo",placeInfo);
        return responsePlaceInfo;
    }

}
