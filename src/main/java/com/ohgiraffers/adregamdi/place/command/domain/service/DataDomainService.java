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
import java.util.*;


@Service
public class DataDomainService {

    public String getOpenAPIKey() {
        String key = "ytkrp5rd6pgbz87v";
        return key;
    }

    public int getPlaceDataTotalPage(String key, int currentPage, int categoryNo) {
        int totalPage;
        try {
            URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + key + "&locale=kr&category=c" + categoryNo + "&page=" + currentPage);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
            String result = br.readLine();

            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObject = (JSONObject) jsonParser.parse(result);
            totalPage = Integer.parseInt(String.valueOf(jsonObject.get("pageCount")));

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

    public JSONArray getPlaceInfosInPage(String key, int currentPage, int categoryNo) {

            try {
                URL url = new URL("http://api.visitjeju.net/vsjApi/contents/searchList?apiKey=" + key + "&locale=kr&category=c" + categoryNo + "&page=" + currentPage);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
                String result = br.readLine();

                JSONParser jsonParser = new JSONParser();
                JSONObject jsonObject = (JSONObject) jsonParser.parse(result);

                JSONArray placeInfo = (JSONArray) jsonObject.get("items");

                return placeInfo;

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

    public Map<String, String> parsePlaceInfo(JSONObject item) {

        Map<String, String> placeInfo = new HashMap<>();
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
        placeInfo.put("categoryCode", categoryCode);
        placeInfo.put("categoryName", categoryName);
        System.out.println("categoryCode = " + categoryCode);   // 진행 상황 알기 위해 일부러 남겨둠!

        // 설명. items - title
        String title = (String) item.getOrDefault("title", "");
        placeInfo.put("title", title);

        // 설명. items - region1cd
        JSONObject region1cd = (JSONObject) item.getOrDefault("region1cd", "");
        // 설명. items - region1cd - value, label
        String cityName = "";
        if (region1cd == null) {
            cityName = "";
        } else {
            cityName = (String) region1cd.getOrDefault("label", "");
        }
        placeInfo.put("cityName", cityName);

        // 설명. items - region2cd
        JSONObject region2cd = (JSONObject) item.getOrDefault("region2cd", "");
        int dongCode = 0;
        String dongName = "";
        if (region2cd != null) {
            dongCode = Integer.parseInt(String.valueOf(region2cd.getOrDefault("value", 0)));
            dongName = (String) region2cd.getOrDefault("label", "");
        }
        // 설명. items - region2cd - value, label
        placeInfo.put("dongCode", String.valueOf(dongCode));
        placeInfo.put("dongName", dongName);

        // 설명. items - address, roadaddress, postcode, phoneno
        String address = (String) item.getOrDefault("address", "");
        String roadAddress = (String) item.getOrDefault("roadaddress", "");
        String postCode = (String) item.getOrDefault("postcode", "");
        String phoneNo = (String) item.getOrDefault("phoneno", "");
        placeInfo.put("address", address);
        placeInfo.put("roadAddress", roadAddress);
        placeInfo.put("postCode", postCode);
        placeInfo.put("phoneNo", phoneNo);

        // 설명. items - introduction
        String introduction = (String) item.getOrDefault("introduction", "");
        placeInfo.put("introduction", introduction);

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
        placeInfo.put("lat", String.valueOf(lat));
        placeInfo.put("lng", String.valueOf(lng));

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
        placeInfo.put("imagePath",imagePath);
        placeInfo.put("thumbnailPath", thumbnailPath);

        return placeInfo;
    }

    public List<String> parseAllTagsWithValidCheck(JSONObject item) {
        String[] allTags;
        if (item.get("alltag") == null) {
            allTags = new String[0];
        } else {
            allTags = ((String) item.get("alltag")).split("\\s*,\\s*"); // ',' 앞 뒤로 공백 제거
            for (int i = 0; i < allTags.length; i++) {
                String tag = allTags[i];
                tag = tag.replaceAll("\\s+", ""); // 전체 공백 제거
                if (tag.isEmpty()) {continue;}

                tag = tag.replaceAll("[^\\p{IsAlphabetic}\\p{IsDigit}\\p{IsHangul}~%&]", "");
                allTags[i] = tag;
            }
        }
        return Arrays.asList(allTags);
    }

}


