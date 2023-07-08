package com.ohgiraffers.adregamdi.user.command.application.service;

import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.repository.UserRepository;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class OAuthService {
    private final UserDomainService userDomainService;
    private final UserRepository userRepository;

    @Autowired
    public OAuthService(UserDomainService userDomainService, UserRepository userRepository) {
        this.userDomainService = userDomainService;
        this.userRepository = userRepository;
    }

    public int login(String code) {
        String token = userDomainService.getKakaoAccessToken(code); // 액세스 토큰 발행
        UserDTO userInfo = userDomainService.getUserInfo(token); // 카카오로부터 유저 정보 조회
        return userRepository.insertUser(userInfo);// 우리 db로
    }

    public void logout(String token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String result = "";
            String line = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
