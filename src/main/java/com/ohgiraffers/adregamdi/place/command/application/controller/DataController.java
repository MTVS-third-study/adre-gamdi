package com.ohgiraffers.adregamdi.place.command.application.controller;

import com.ohgiraffers.adregamdi.place.command.application.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/data/*")
public class DataController {

    private final DataService dataService;

    @Autowired
    public DataController(DataService dataService){
        this.dataService = dataService;
    }

    @GetMapping("/request")
    public String getPlaceData() {
        dataService.getPlaceData();
        return "redirect:/";
    }

}
