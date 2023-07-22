package com.ohgiraffers.adregamdi.place.query.application.controller;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.query.application.service.PlaceQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/placeQuery")
public class PlaceQueryController {

    private final PlaceQueryService placeQueryService;
    @Autowired
    public PlaceQueryController(PlaceQueryService placeQueryService){
        this.placeQueryService = placeQueryService;
    }

    @GetMapping("/searchPlace")
    public String searchPlace(@RequestParam("searchKeyword") String keyword, Model model){
        List<PlaceDTO> placeList = placeQueryService.findPlaceByKeyword(keyword);
        model.addAttribute("placeList", placeList);
        System.out.println("keyword = " + keyword);
        placeList.forEach(System.out::println);
        return "schedule";
    }

    @ResponseBody
    @RequestMapping(value = "/placeInfo",method = RequestMethod.GET)
    public Map<String,List<PlaceDTO>> placeInfo(@RequestParam("searchKeyword") String keyword, Model model){
        List<PlaceDTO> placeList = placeQueryService.findPlaceByKeyword(keyword);
        Map<String,List<PlaceDTO>> mapPlaceList=new HashMap<>();
        mapPlaceList.put("searchedList",placeList);

        System.out.println("keyword = " + keyword);
        placeList.forEach(System.out::println);
        return mapPlaceList;
    }

}
