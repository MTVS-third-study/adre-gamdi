package com.ohgiraffers.adregamdi.user.command.application.controller;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.application.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // 회원 등급 변경
    @PostMapping("updateGrade")
    public void updateGrade(@RequestParam("grade") int grade, HttpServletResponse response, HttpSession session) throws Exception {
        UserDTO loginUser = (UserDTO) session.getAttribute("loginUser");
        session.setAttribute("loginUser", adminService.updateGrade(grade, loginUser));
        response.sendRedirect("http://localhost:9090/adminPage"); // 메인 페이지로
    }

}