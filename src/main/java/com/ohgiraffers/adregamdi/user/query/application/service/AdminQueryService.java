package com.ohgiraffers.adregamdi.user.query.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.aggregate.entity.User;
import com.ohgiraffers.adregamdi.user.query.infrastructure.repository.AdminRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminQueryService {
    private final AdminRepository adminRepository;

    public AdminQueryService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<UserDTO> findAllUser() {

        List<User> user = adminRepository.findAll();
        List<UserDTO> userList = user.stream()
                .map(m -> new UserDTO(m.getUserNo(),
                        m.getKakaoId(),
                        m.getKakaoProfileImage(),
                        m.getKakaoNickName(),
                        m.getServiceNickName(),
                        m.getEmail(),
                        m.getAge(),
                        m.getGender(),
                        m.getReport_count(),
                        m.getReview_count(),
                        m.getGrade(),
                        m.isBlacklist_status(),
                        m.getRole()))
                .collect(Collectors.toList());
        return userList;
    }
}
