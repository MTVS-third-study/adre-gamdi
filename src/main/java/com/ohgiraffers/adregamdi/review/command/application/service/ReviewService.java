package com.ohgiraffers.adregamdi.review.command.application.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.review.command.application.dto.ReviewDTO;
import com.ohgiraffers.adregamdi.review.command.domain.service.CreateReviewService;
import com.ohgiraffers.adregamdi.review.command.domain.service.DeleteReviewService;
import com.ohgiraffers.adregamdi.review.command.domain.service.UpdateReviewService;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Service
public class ReviewService {

    private final CreateReviewService createReviewService;
    private final UpdateReviewService updateReviewService;
    private final DeleteReviewService deleteReviewService;

    @Autowired
    public ReviewService(CreateReviewService createReviewService, UpdateReviewService updateReviewService, DeleteReviewService deleteReviewService) {
        this.createReviewService = createReviewService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
    }

    public boolean insertReview(ReviewDTO reviewDTO, MultipartFile imageFile, Model model, Long userId, Long placeId) {

        if (createReviewService.isNotNull(reviewDTO, imageFile, model) && createReviewService.insertReviewImage(reviewDTO, imageFile, model)) {

            createReviewService.saveReview(reviewDTO, userId, placeId);
            return true;
        }
        return false;
    }

    public void updateReview() {
        updateReviewService.updateReview();
    }

    public void deleteReview() {
        deleteReviewService.deleteReview();
    }

    public void alert(String notice, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<script type='text/javascript'>");
        out.println("alert('" + notice + "');");
        out.println("</script>");
        out.flush();
    }
}
