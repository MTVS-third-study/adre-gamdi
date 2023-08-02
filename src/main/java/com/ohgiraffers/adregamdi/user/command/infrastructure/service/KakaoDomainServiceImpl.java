package com.ohgiraffers.adregamdi.user.command.infrastructure.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.ohgiraffers.adregamdi.common.annotation.InfraService;
import com.ohgiraffers.adregamdi.user.command.application.dto.KakaoUserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.service.KakaoDomainService;
import com.ohgiraffers.adregamdi.user.query.application.service.KakaoQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@InfraService
public class KakaoDomainServiceImpl implements KakaoDomainService {
    private final KakaoQueryService kakaoQueryService;

    @Autowired
    public KakaoDomainServiceImpl(KakaoQueryService kakaoQueryService) {
        this.kakaoQueryService = kakaoQueryService;
    }

    // 카카오 유저 정보 조회
    public KakaoUserDTO getKakaoUserInfo(String code) {
        return kakaoQueryService.validateKakaoCertification(code);
    }

    // 카카오 로그아웃
    public Long logout(String token) {
        String reqURL = "https://kapi.kakao.com/v1/user/logout";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder result = new StringBuilder();
            String line = "";

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result); // 응답

            //Gson 라이브러리로 JSON파싱
            JsonElement element = JsonParser.parseString(result.toString());

            return element.getAsJsonObject().get("id").getAsLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }

    // 카카오 연결끊기
    @Override
    public Long unlinkKakao(String token) {
        String reqURL = "https://kapi.kakao.com/v1/user/unlink";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + token);

            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder result = new StringBuilder();
            String line = "";

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result); // 응답

            //Gson 라이브러리로 JSON파싱
            JsonElement element = JsonParser.parseString(result.toString());

            return element.getAsJsonObject().get("id").getAsLong();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0L;
    }
}