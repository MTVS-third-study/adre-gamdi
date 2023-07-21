package com.ohgiraffers.adregamdi.data.command.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.command.application.service.CategoryService;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.service.CityService;
import com.ohgiraffers.adregamdi.data.command.application.dto.DataDTO;
import com.ohgiraffers.adregamdi.data.command.application.dto.TagDataDTO;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataAPIService;
import com.ohgiraffers.adregamdi.data.command.domain.service.DataDomainService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/** <pre>
 *  url 요청 시 openAPI에서 데이터를 전송 받음과 동시에 DB에 유효성과 insert를 진행하는 로직
 * </pre>
 */
@Service
public class DataService {

    private final DataAPIService dataAPIService;
    private final DataDomainService dataDomainService;

    private final CategoryService categoryService;

    private final CityService cityService;


    @Autowired
    public DataService(DataAPIService dataAPIService,
                       DataDomainService dataDomainService,
                       CategoryService categoryService,
                       CityService cityService) {
        this.dataAPIService = dataAPIService;
        this.dataDomainService = dataDomainService;
        this.categoryService = categoryService;
        this.cityService = cityService;
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
                        TagDataDTO tagDataDTO = new TagDataDTO();
//                        Category category = insertCategory(new Category(placeInfos.get("categoryName")));
//                        City city = insertCity(new City(placeInfos.get("cityName")));
//                        Dong dong = insertDong(new Dong(Integer.parseInt(placeInfos.get("dongCode")), placeInfos.get("dongName")));
//                        Place place = insertPlace(new Place(
//                                placeInfos.get("title"),
//                                new CategoryVO(category.getCategoryNo()),
//                                new CityVO(city.getCityNo()),
//                                new DongVO(dong.getDongNo()),
//                                placeInfos.get("introduction"),
//                                placeInfos.get("phoneNo"),
//                                new CoordinateVO(Double.parseDouble(placeInfos.get("lat")), Double.parseDouble(placeInfos.get("lng"))),
//                                placeInfos.get("postCode"),
//                                placeInfos.get("address"),
//                                placeInfos.get("roadAddress"),
//                                placeInfos.get("imagePath"),
//                                placeInfos.get("thumbnailPath"),
//                                0,
//                                0
//                        ));
//                        List<Tag> insertTagResultList = tagList.stream().distinct().map(m -> insertTag(m)).collect(Collectors.toList()); // 태그 insert 결과 객체를 리스트로 저장
//                        insertTagResultList.stream().forEach(t -> insertPlaceAndTags(
//                                new PlaceVO(place.getPlaceNo())
//                                , new TagVO(t.getTagNo())
//                        ));
                        /* 카테고리*/
                        insertCategory(placeInfos.get("categoryName"));
                        dataDTO.setCategoryName(placeInfos.get("categoryName"));
                        /* 도시 */
                        insertCity(placeInfos.get("cityName")); // 새로운 도시가 있다면 insert
                        dataDTO.setCityName(placeInfos.get("cityName"));
                        /* 동 */
                        insertDong(Integer.parseInt(placeInfos.get("dongCode")), placeInfos.get("dongName"));
                        dataDTO.setDongCode(Integer.parseInt(placeInfos.get("dongCode"));
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

                        List<String> tagList = dataDomainService.parseAllTagsWithValidCheck(item); // 한 장소의 태그들
                        tagDataDTO.setTagList(tagList);
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
            return ";
        }

        CategoryDTO insertedCategory = dataAPIService.insertCategory(categoryName);
        if (insertedCategory == null) {
            return "fail";
        }
        return "success";
    }

    public String insertCity(String cityName) {

        CityQueryDTO findResult = dataAPIService.findCityByCityName(cityName);
        if (findResult != null) {
            return "already exists";
        }

        CityDTO insertedCity = dataAPIService.insertCity(cityName);
        if (insertedCity == null) {
            return "fail";
        }
        return "success";
    }

    public String insertDong(int dongCode, String dongName) {

        DongQueryDTO findResult = dataAPIService.findDongByDongName(dongName);
        if (findResult != null) {
            return "already exists";
        }

        DongDTO insertedDong = dataAPIService.insertDong(new DongDTO(dongCode, dongName));
        if (insertedDong == null) {
            return "fail";
        }
        return "success";
    }

    public Place insertPlace(DataDTO dataDTO) {
        dataAPIService.insertPlace(dataDTO);
        return null;
    }




    public PlaceTags insertPlaceAndTags(PlaceVO placeVO, TagVO tagVO) {
        return placeTagsRepository.save(new PlaceTags(placeVO, tagVO));
    }

    public Tag insertTag(String tagName) { // 중복 제외 태그 insert

        Tag findResult = dataAPIService.findTagByTagName(tagName);
        if (findResult != null) {
            return findResult;
        }

        return tagRepository.save(new Tag(tagName));
    }

}
