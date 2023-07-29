package com.ohgiraffers.adregamdi.review.command.application.controller;

import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.application.service.ReviewService;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/regist")
    public ResponseEntity<String> registReview(ReviewDTO reviewDTO,
                                               @RequestParam MultipartFile imageFile,
                                               HttpServletRequest request,
                                               HttpServletResponse response,
                                               Model model,
                                               HttpSession session) throws IOException {
        Long placeNo = Long.valueOf(request.getParameter("placeNo"));
        Long userNo = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
        String userName = ((UserDTO) session.getAttribute("loginUser")).getKakaoNickName();
        if (reviewService.insertReview(reviewDTO, imageFile, model, userNo, userName, placeNo)) {
            return ResponseEntity.ok("성공적으로 등록되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("등록 실패");
        }
    }


    private void alert(String notice, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert('" + notice + "');");
        out.println("</script>");
        out.flush();
    }
}
