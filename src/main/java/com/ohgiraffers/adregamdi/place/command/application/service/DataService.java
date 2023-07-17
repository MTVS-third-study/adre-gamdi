package com.ohgiraffers.adregamdi.place.command.application.service;

import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.*;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.*;
import com.ohgiraffers.adregamdi.place.command.domain.repository.*;
import com.ohgiraffers.adregamdi.place.command.domain.service.DataDomainService;
import com.ohgiraffers.adregamdi.place.command.domain.service.PlaceAPIService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
public class DataService {

    private final PlaceAPIService placeAPIService;
    private final DataDomainService dataDomainService;


    private final PlaceRepository placeRepository;
    private final CategoryRepository categoryRepository;
    private final CityRepository cityRepository;
    private final DongRepository dongRepository;
    private final TagRepository tagRepository;
    private final PlaceTagsRepository placeTagsRepository;

    @Autowired
    public DataService(PlaceAPIService placeAPIService, DataDomainService dataDomainService, PlaceRepository placeRepository, CategoryRepository categoryRepository,
                       CityRepository cityRepository, DongRepository dongRepository, TagRepository tagRepository, PlaceTagsRepository placeTagsRepository) {
        this.placeAPIService = placeAPIService;
        this.dataDomainService = dataDomainService;
        this.placeRepository = placeRepository;
        this.categoryRepository = categoryRepository;
        this.cityRepository = cityRepository;
        this.dongRepository = dongRepository;
        this.tagRepository = tagRepository;
        this.placeTagsRepository = placeTagsRepository;
    }

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
                        Category category = insertCategory(new Category(placeInfos.get("categoryName")));
                        City city = insertCity(new City(placeInfos.get("cityName")));
                        Dong dong = insertDong(new Dong(Integer.parseInt(placeInfos.get("dongCode")), placeInfos.get("dongName")));
                        Place place = insertPlace(new Place(
                                placeInfos.get("placeName"),
                                new CategoryVO(category.getCategoryNo()),
                                new CityVO(city.getCityNo()),
                                new DongVO(dong.getDongNo()),
                                placeInfos.get("introduction"),
                                placeInfos.get("phoneNumber"),
                                new CoordinateVO(Double.parseDouble(placeInfos.get("lat")), Double.parseDouble(placeInfos.get("lng"))),
                                placeInfos.get("postCode"),
                                placeInfos.get("address"),
                                placeInfos.get("roadAddress"),
                                placeInfos.get("imagePath"),
                                placeInfos.get("thumbnailpath"),
                                0,
                                0
                        ));

                        List<String> tagList = dataDomainService.parseAllTags(item); // 한 장소의 태그들
                        List<Tag> insertTagResultList = tagList.stream().distinct().map(m -> insertTag(m)).collect(Collectors.toList()); // 태그 insert 결과 객체를 리스트로 저장
                        insertTagResultList.stream().forEach(t -> insertPlaceAndTags(
                                new PlaceVO(place.getPlaceNo())
                                , new TagVO(t.getTagNo())
                        ));
                    }

                }
                currentPage = 1;
            }
    }

    public PlaceTags insertPlaceAndTags(PlaceVO placeVO, TagVO tagVO) {
        return placeTagsRepository.save(new PlaceTags(placeVO, tagVO));
    }

    public Place insertPlace(Place place) {

        Place findResult = placeAPIService.findPlaceByPlaceNameAndRoadPlaceAddress(place.getPlaceName(), place.getRoadPlaceAddress());
        if (findResult != null) {
            return findResult;
        }
        return placeRepository.save(place);
    }

    public Dong insertDong(Dong dong) {

        Dong findResult = placeAPIService.findDongByDongName(dong.getDongName());
        if (findResult != null) {
            return findResult;
        }
        return dongRepository.save(dong);
    }

    public City insertCity(City city) {

        City findResult = placeAPIService.findCityByCityName(city.getCityName());
        if (findResult != null) {
            return findResult;
        }
        return cityRepository.save(city);
    }

    public Category insertCategory(Category category) {
        Category findResult = placeAPIService.findCategoryByCategoryName(category.getCategoryName()); // 중복 확인
        if (findResult != null) {
            return findResult;
        }
        return categoryRepository.save(category);
    }

    public Tag insertTag(String tagName) { // 중복 제외 태그 insert

        Tag findResult = placeAPIService.findTagByTagName(tagName);
        if (findResult != null) {
            return findResult;
        }

        return tagRepository.save(new Tag(tagName));
    }

}
