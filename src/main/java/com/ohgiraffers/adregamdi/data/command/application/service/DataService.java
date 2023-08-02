package com.ohgiraffers.adregamdi.data.command.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.tag.command.application.dto.TagDTO;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataAPIService;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataDomainService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/** <pre>
 *  url 요청 시 openAPI에서 데이터를 전송 받음과 동시에 DB에 유효성과 insert를 진행하는 로직
 * </pre>
 */
@Service
public class DataService {

    private final DataAPIService dataAPIService;
    private final DataDomainService dataDomainService;

    @Autowired
    public DataService(DataAPIService dataAPIService,
                       DataDomainService dataDomainService) {
        this.dataAPIService = dataAPIService;
        this.dataDomainService = dataDomainService;
    }

    @Transactional
    public void getPlaceData() {

            // 필기. 세션에 저장된 아이디가 관리자인지 구분해서 예외 처리

            String key = dataDomainService.getOpenAPIKey();
            int[] categoryNo = {1, 2, 3, 4}; // 1- 관광지, 2 - 쇼핑, 3 - 숙박, 4- 음식점, 6 - 테마 여행
            int currentPage = 1;
            int totalPage = 0;

            int categoryNoLength = categoryNo.length;
            for (int i = 0; i < categoryNoLength; i++) {

                totalPage = dataDomainService.getPlaceDataTotalPage(key, currentPage, categoryNo[i]);
                for (int j = currentPage; j <= totalPage; j++) {
                    JSONArray placeInfoArray = dataDomainService.getPlaceInfosInPage(key, j, categoryNo[i]);   // 페이지 당 items(여러 장소 정보)

                    int placeInfoArraySize = placeInfoArray.size();
                    for (int k = 0; k < placeInfoArraySize; k++) {
                        JSONObject item = (JSONObject) placeInfoArray.get(k);    // 한 장소

                        Map<String, String> placeInfos = dataDomainService.parsePlaceInfo(item);    // 한 장소의 정보들
                        DataDTO dataDTO = new DataDTO();
                        /* 카테고리*/
                        dataDTO.setCategoryNo(
                            insertCategory(placeInfos.get("categoryName")).getCategoryNo()
                        );
                        dataDTO.setCategoryName(placeInfos.get("categoryName"));
                        /* 도시 */
                        dataDTO.setCityNo(
                                insertCity(placeInfos.get("cityName")).getCityNo()
                        );
                        dataDTO.setCityName(placeInfos.get("cityName"));
                        /* 동 */
                        insertDong(Integer.parseInt(placeInfos.get("dongCode")), placeInfos.get("dongName"));
                        dataDTO.setDongCode(Integer.parseInt(placeInfos.get("dongCode")));
                        dataDTO.setDongName(placeInfos.get("dongName"));

                        dataDTO.setPlaceName(placeInfos.get("title"));
                        dataDTO.setPlaceIntroduction(placeInfos.get("introduction"));
                        dataDTO.setPhoneNo(placeInfos.get("phoneNo"));
                        dataDTO.setLat(Double.parseDouble(placeInfos.get("lat")));
                        dataDTO.setLng(Double.parseDouble(placeInfos.get("lng")));
                        dataDTO.setPostCode(placeInfos.get("postCode"));
                        dataDTO.setAddress(placeInfos.get("address"));
                        dataDTO.setRoadAddress(placeInfos.get("roadAddress"));
                        dataDTO.setImagePath(placeInfos.get("imagePath"));
                        dataDTO.setThumbnailPath(placeInfos.get("thumbnailPath"));
                        Long insertedPlaceNo = insertPlace(dataDTO);

                        List<String> tagList = dataDomainService.parseAllTagsWithValidCheck(item); // 한 장소의 태그들
                        List<TagDTO> insertTagResultList = tagList.stream().distinct().map(m -> insertTag(m)).collect(Collectors.toList()); // 태그 insert 결과 객체를 리스트로 저장
                        insertTagResultList.stream().forEach(t -> insertPlaceAndTags(
                                insertedPlaceNo,
                                t.getTagNo()
                        ));

                    }
                    currentPage = j + 1;
                }
                currentPage = 1;
            }
        System.out.println("완료");
    }

    public CategoryDTO insertCategory(String categoryName) {

        CategoryDTO findResult = dataAPIService.findCategoryByCategoryName(categoryName);
        if (findResult != null) {
            return findResult;
        }
        CategoryDTO insertedCategory = dataAPIService.insertCategory(categoryName);
        return insertedCategory;
    }

    public CityDTO insertCity(String cityName) {

        CityDTO findResult = dataAPIService.findCityByCityName(cityName);
        if (findResult != null) {
            return findResult;
        }

        CityDTO insertedCity = dataAPIService.insertCity(cityName);
        return insertedCity;
    }

    public DongDTO insertDong(int dongCode, String dongName) {

        DongDTO findResult = dataAPIService.findDongByDongName(dongName);
        if (findResult != null) {
            return findResult;
        }

        DongDTO insertedDong = dataAPIService.insertDong(new DongDTO(dongCode, dongName));
        return insertedDong;
    }

    public Long insertPlace(DataDTO dataDTO) {
        Long insertedPlaceNo = dataAPIService.insertPlace(dataDTO);
        return insertedPlaceNo;
    }

    public TagDTO insertTag(String tagName) { // 중복 제외 태그 insert

        TagDTO findResult = dataAPIService.findTagByTagName(tagName);
        if (findResult != null) {
            return findResult;
        }
        TagDTO insertedTag = dataAPIService.insertTag(tagName);
        return insertedTag;
    }

    public Long insertPlaceAndTags(Long placeNo, Long tagNo) {
        return dataAPIService.insertPlaceAndTags(new PlaceTagsDTO(placeNo, tagNo));
    }

}
