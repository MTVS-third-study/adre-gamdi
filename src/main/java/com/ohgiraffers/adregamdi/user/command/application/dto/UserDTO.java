package com.ohgiraffers.adregamdi.user.command.application.dto;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Long userNo;
    private String kakaoId;
    private String kakaoNickName;
    private String serviceNickName;
    private String email;
    private String age;
    private String gender;
    private int report_count;
    private int review_count;
    private int grade;
    private boolean blacklist_status;

    public static UserDTO of(User user){
        UserDTO userDTO=new UserDTO();
        userDTO.userNo=user.getUserNo();
        userDTO.id=user.getId();
        userDTO.kakaoNickName=user.getKakaoNickName();
        userDTO.serviceNickName=user.getServiceNickName();
        userDTO.email=user.getEmail();
        userDTO.age=user.getAge();
        userDTO.gender=user.getGender();
        userDTO.report_count=user.getReport_count();
        userDTO.review_count=user.getReview_count();
        userDTO.grade=user.getGrade();
        userDTO.blacklist_status=user.isBlacklist_status();
        userDTO.access_Token=user.getAccess_Token();
        userDTO.refresh_Token=user.getRefresh_Token();
        return userDTO;

    }
}
