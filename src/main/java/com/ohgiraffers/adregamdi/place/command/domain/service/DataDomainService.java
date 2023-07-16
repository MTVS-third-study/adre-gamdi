package com.ohgiraffers.adregamdi.place.command.domain.service;

import org.json.simple.JSONArray;
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
        int[] categoryNo = {1, 2, 3, 4}; // 1- 관광지, 2 - 쇼핑, 3 - 숙박, 4- 음식점, 6 - 테마 여행
        int currentPage = 1;
        int totalPage = 0;

        for (int i = 0; i < categoryNo.length; i++) {
                getPlaceDataTotalPage(key, currentPage, categoryNo[i]);
                currentPage = 1;
        }
    }

    private int getPlaceDataTotalPage(String key, int currentPage, int categoryNo) {
        int totalPage;
        try {
            URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + key + "&locale=kr&category=c" + categoryNo + "&page=" + currentPage);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = br.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            totalPage = Integer.parseInt(String.valueOf(jsonObject.get("pageCount")));

            // 설명. 본격적 파싱
            parsePlace(key, currentPage, totalPage, categoryNo);

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return totalPage;
    }

    private void parsePlace(String key, int currentPage, int totalPage, int categoryNo) {

        for (int j = currentPage; j <= totalPage; j++) {
            try {
                URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + key + "&locale=kr&category=c" + categoryNo + "&page=" + currentPage);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String result = br.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

                JSONArray placeInfo = (JSONArray) jsonObject.get("items");
                System.out.println("placeInfo = " + placeInfo);
                System.out.println("placeInfo.size() = " + placeInfo.size());

                for (int k = 0; k < placeInfo.size(); k++) {
                    JSONObject item = (JSONObject) placeInfo.get(k);
                    System.out.println("item = " + item);

                    // items - alltags
                    String[] allTags;
                    if (item.get("alltag") == null) {
                        allTags = new String[0];
                    } else {
                        allTags = ((String) item.get("alltag")).split("\\s*,\\s*"); // ',' 앞 뒤로 공백 제거
                    }
                    List<String> tagList = Arrays.asList(allTags); // 태그들 리스트화
                    System.out.println("tagList = " + tagList);

                    // 설명. items - contentscd
                    JSONObject contentsCd = (JSONObject) item.getOrDefault("contentscd", "");
                    // 설명. items - contentscd - value, label
                    String categoryCode = "";
                    String categoryName = "";
                    if (contentsCd == null) {
                        categoryCode = "";
                        categoryName = "";
                    } else {
                        categoryCode = (String) contentsCd.getOrDefault("value", "");
                        categoryName = (String) contentsCd.getOrDefault("label", "");
                    }
                    System.out.println("categoryCode = " + categoryCode);
                    System.out.println("categoryName = " + categoryName);


                    // 설명. items - title
                    String title = (String) item.getOrDefault("title", "");
                    System.out.println("title = " + title);

                    // 설명. items - region1cd
                    JSONObject region1cd = (JSONObject) item.getOrDefault("region1cd", "");
                    // 설명. items - region1cd - value, label
                    String cityCode = "";
                    String cityName = "";
                    if (region1cd == null) {
                        cityCode = "";
                        cityName = "";
                    } else {
                        cityCode = (String) region1cd.getOrDefault("value", "");
                        cityName = (String) region1cd.getOrDefault("label", "");
                    }
                    System.out.println("siCode = " + cityCode);
                    System.out.println("siName = " + cityName);

                    // 설명. items - region2cd
                    JSONObject region2cd = (JSONObject) item.get("region2cd");
                    int dongCode = 0;
                    String dongName = "";
                    if (region2cd != null) {
                        dongCode = Integer.parseInt(String.valueOf(region2cd.getOrDefault("value", 0)));
                        dongName = (String) region2cd.getOrDefault("label", "");
                    }
                    // 설명. items - region2cd - value, label
                    System.out.println("dongCode = " + dongCode);
                    System.out.println("dongName = " + dongName);

                    // 설명. items - address, roadaddress, postcode, phoneno
                    String address = (String) item.getOrDefault("address", "");
                    String roadAddress = (String) item.getOrDefault("roadaddress", "");
                    String postCode = (String) item.getOrDefault("postcode", "");
                    String phoneNo = (String) item.getOrDefault("phoneno", "");
                    System.out.println("address = " + address);
                    System.out.println("roadAddress = " + roadAddress);
                    System.out.println("postCode = " + postCode);
                    System.out.println("phoneNo = " + phoneNo);

                    // 설명. items - introduction
                    String introduction = (String) item.getOrDefault("introduction", "");
                    System.out.println("introduction = " + introduction);

                    // 설명. items - latitude, longitude
                    double lat = 0;
                    double lng = 0;
                    if (item.get("latitude") != null) {
                        lat = Double.parseDouble(String.valueOf(item.get("latitude")));
                    } else {
                        lat = 0;
                    }
                    if (item.get("longitude") != null) {
                        lng = Double.parseDouble(String.valueOf(item.get("longitude")));
                    } else {
                        lng = 0;
                    }
                    System.out.println("lat = " + lat);
                    System.out.println("lng = " + lng);

                    // 설명. items - repPhoto
                    JSONObject repPhoto = (JSONObject) item.getOrDefault("repPhoto", "");
                    String imagePath = "";
                    String thumbnailPath = "";
                    if (repPhoto != null) {
                        // 설명. items - repPhoto - photoid
                        JSONObject photoId = (JSONObject) repPhoto.getOrDefault("photoid", "");
                        // 설명. items - repPhoto - photoid - imgpath, thumbnailpath
                        if (photoId != null) {
                            imagePath = (String) photoId.getOrDefault("imgpath", "");
                            thumbnailPath = (String) photoId.getOrDefault("thumbnailpath", "");
                        }
                    }
                    System.out.println("imagePath = " + imagePath);
                    System.out.println("thumbnailpath = " + thumbnailPath);
                }
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
        // items에서 필요한 것들 alltag, 'contentscd', title, 'region1cd', 'region2cd', address, roadaddress, introduction
        // , latitude, longitude, postcode, phoneno, 'repPhoto'
    }
}


