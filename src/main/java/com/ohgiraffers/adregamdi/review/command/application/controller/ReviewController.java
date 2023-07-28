package com.ohgiraffers.adregamdi.review.command.application.controller;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.query.application.dto.ResponsePlaceDTO;
import com.ohgiraffers.adregamdi.placebyschedule.domain.aggregate.vo.PlaceNo;
import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.application.service.ReviewService;
import com.ohgiraffers.adregamdi.review.query.application.controller.ReviewQueryController;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }


//    @ResponseBody
//    @GetMapping("")
//    public ReviewController(){
//
//    }

    @ResponseBody
    @PostMapping("/regist")
    public void registReview(ReviewDTO reviewDTO,
                               @RequestParam MultipartFile imageFile,

                               HttpServletResponse response,
                               Model model,
                               HttpSession session) throws IOException {
//        Long placeNo = responsePlaceDTO.getPlaceNo();
        Long placeNo = 20L;
//        System.out.println("placeNo = " + placeNo);
        Long userNo = ((UserDTO) session.getAttribute("loginUser")).getUserNo();
        String userName = ((UserDTO) session.getAttribute("loginUser")).getKakaoNickName();
//        Map<String, ReviewDTO> reviewDTOMap = new HashMap<>();
//        reviewDTOMap.put("reviewRegist", reviewDTO);
        if (reviewService.insertReview(reviewDTO, imageFile, model, userNo, userName, placeNo)) {
//            alert("리뷰가 등록되었습니다.", response);
//            return "/schedule";
        } else {
//            alert("리뷰 등록에 실패하였습니다.", response);
//            return "/schedule";
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
