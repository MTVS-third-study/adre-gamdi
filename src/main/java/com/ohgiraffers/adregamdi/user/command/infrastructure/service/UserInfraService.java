package com.ohgiraffers.adregamdi.user.command.infrastructure.service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ohgiraffers.adregamdi.user.command.application.dto.UserDTO;
import com.ohgiraffers.adregamdi.user.command.domain.service.UserDomainService;
import com.ohgiraffers.adregamdi.user.query.application.service.UserFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class UserInfraService implements UserDomainService {
    private final UserFindService userFindService;

    @Autowired
    public UserInfraService(UserFindService userFindService) {
        this.userFindService = userFindService;
    }

    //
    @Override
    public String getKakaoAccessToken(String code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";

        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            String sb = "grant_type=authorization_code" +
                    "&client_id=dd52d3a258bf3ccbc37de832dfecd0d4" + // REST API 키
                    "&redirect_uri=http://localhost:8080/oauth/kakao/login" + // Redirect URI
                    "&code=" + code;
            System.out.println(sb);
            bw.write(sb);
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonElement element = JsonParser.parseString(result.toString());

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return access_Token;
    }

    @Override
    public UserDTO getKakaoUserInfo(String token) {
        String reqURL = "https://kapi.kakao.com/v2/user/me";
        UserDTO userInfo = null;

        //access_token을 이용하여 사용자 정보 조회
        try {
            URL url = new URL(reqURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            System.out.println("token = " + token);
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Authorization", "Bearer " + token); //전송할 header 작성, access_token전송

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            StringBuilder result = new StringBuilder();

            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리로 JSON파싱
            JsonElement element = JsonParser.parseString(result.toString());

            JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
            JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();

            String id = element.getAsJsonObject().get("id").getAsString();
            String nickname = properties.getAsJsonObject().get("nickname").getAsString();

            String email = "";
            try {
                if ("".equals(kakao_account.getAsJsonObject().get("email").getAsString())
                        || kakao_account.getAsJsonObject().get("email").getAsString() == null) {
                    throw new NullPointerException();
                } else {
                    email = kakao_account.getAsJsonObject().get("email").getAsString();
                }
            } catch (NullPointerException ne) {
                ne.printStackTrace();
            }

            String age = "";
            try {
                if ("".equals(kakao_account.getAsJsonObject().get("age_range").getAsString())
                        || kakao_account.getAsJsonObject().get("age_range").getAsString() == null) {
                    throw new NullPointerException();
                } else {
                    age = kakao_account.getAsJsonObject().get("age_range").getAsString();
                }
            } catch (NullPointerException ne) {
                ne.printStackTrace();
            }

            String gender = "";
            try {
                if ("".equals(kakao_account.getAsJsonObject().get("gender").getAsString())
                        || kakao_account.getAsJsonObject().get("gender").getAsString() == null) {
                    throw new NullPointerException();
                } else {
                    gender = kakao_account.getAsJsonObject().get("gender").getAsString();
                }
            } catch (NullPointerException ne) {
                ne.printStackTrace();
            }

            userInfo = new UserDTO();
            userInfo.setId(id);
            userInfo.setKakaoNickName(nickname);
            userInfo.setServiceNickName("");
            userInfo.setEmail(email);
            userInfo.setAge(age);
            userInfo.setGender(gender);

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return userInfo;
    }

    @Override
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

            StringBuilder result = new StringBuilder();
            String line = "";

            while ((line = br.readLine()) != null) {
                result.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public UserDTO findOneUser(String id) {
        return userFindService.findOneUser(id);
    }
}
