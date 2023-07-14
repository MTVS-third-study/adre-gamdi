package com.ohgiraffers.adregamdi.place.command.domain.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;


@Service
public class DataDomainService {


    // 데이터 수집 로직
    public void getPlaceData() {

        // 필기. 세션에 저장된 아이디가 관리자인지 구분해서 예외 처리

        String key = "ytkrp5rd6pgbz87v";
        int categoryNo = 1; // 1- 관광지, 2 - 쇼핑, 3 - 숙박, 4- 음식점, 6 - 테마 여행
        int currentPage = 1;
        int totalPage = 0;
        String result = "";

        try {
            URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey="+key+"&locale=kr&category=c"+categoryNo +"&page="+currentPage);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            result = br.readLine();

            System.out.println("result = " + result);

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result); // result는 string이므로
            totalPage = (int) jsonObject.get("pageCount");
            JSONObject placeInfo = (JSONObject) jsonObject.get("items");

            // items에서 필요한 것들 alltag, 'contentscd', title, 'region1cd', 'region2cd', address, roadaddress, introduction
            // , latitude, longitude, postcode, phoneno, 'repPhoto'

            // items - alltags
            String[] allTags = ((String)placeInfo.get("alltag")).split("\\s*,\\s*"); // ',' 앞뒤로 공백제거
            List<String> tagList = Arrays.asList(allTags); // 태그들 리스트화

            // 설명. items - contentscd
            JSONObject contentsCd = (JSONObject) jsonParser.parse("contentscd");
            // 설명. items - contentscd - value, label
            String categoryCode = (String) contentsCd.get("value");
            String categoryName = (String) contentsCd.get("label");

            // 설명. items - title
            String title = (String) placeInfo.get("title");

            // 설명. items - region1cd
            JSONObject region1cd = (JSONObject) jsonParser.parse("region1cd");
            // 설명. items - region1cd - value, label
            String siCode = (String) region1cd.get("value");
            String siName = (String) region1cd.get("label");
            // 설명. items - region2cd
            JSONObject region2cd = (JSONObject) jsonParser.parse("region2cd");
            // 설명. items - region2cd - value, label
            int dongCode = (int) region2cd.get("value");
            String dongName = (String) region2cd.get("label");

            // 설명. items - address, roadaddress, postcode, phoneno
            String address = (String) placeInfo.get("address");
            String roadAddress = (String) placeInfo.get("roadaddress");
            int postCode = (int) placeInfo.get("postcode");
            String phoneNo = (String) placeInfo.get("phoneno");

            // 설명. items - introduction
            String introduction = (String) placeInfo.get("introduction");

            // 설명. items - latitude, longitude
            double lat = (double) placeInfo.get("latitude");
            double lng = (double) placeInfo.get("longitude");

            // 설명. items - repPhoto
            JSONObject repPhoto = (JSONObject) placeInfo.get("repPhoto");
            // 설명. items - repPhoto - photoid
            JSONObject photoId = (JSONObject) placeInfo.get("photoid");
            // 설명. items - repPhoto - photoid - imgpath, thumbnailpath
            String imagePath = (String) placeInfo.get("imgpath");
            String thumbnailpath = (String) placeInfo.get("thumbnailpath");

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


    }
}
