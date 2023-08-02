package com.ohgiraffers.adregamdi.user.query.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.query.application.service.AdminQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/*")
public class AdminQueryController {
    private AdminQueryService adminQueryService;
    @Autowired
    public AdminQueryController(AdminQueryService adminQueryService){
        this.adminQueryService=adminQueryService;
    }
    @GetMapping("adminPage")
    public String userList(Model model){
        List<UserDTO> userList=adminQueryService.findAllUser();
        model.addAttribute("userList",userList);
        return "adminPage";
    }
}
