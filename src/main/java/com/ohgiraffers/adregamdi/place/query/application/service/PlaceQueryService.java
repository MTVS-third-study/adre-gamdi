package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.category.command.application.dto.CategoryDTO;
import com.ohgiraffers.adregamdi.category.query.application.service.CategoryQueryService;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.CityDTO;
import com.ohgiraffers.adregamdi.cityanddong.command.application.dto.DongDTO;
import com.ohgiraffers.adregamdi.cityanddong.query.application.service.CityQueryService;
import com.ohgiraffers.adregamdi.cityanddong.query.application.service.DongQueryService;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceDTO;
import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.query.application.dto.ResponsePlaceDTO;
import com.ohgiraffers.adregamdi.place.query.domain.entity.SearchPlace;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceMapper;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlaceQueryService {

    private final PlaceMapper placeMapper;
    private final PlaceQueryRepository placeQueryRepository;
    private final PlaceTagsQueryService placeTagsQueryService;
    private final CategoryQueryService categoryQueryService;
    private final CityQueryService cityQueryService;
    private final DongQueryService dongQueryService;

    @Autowired
    public PlaceQueryService(PlaceMapper placeMapper,
                             PlaceQueryRepository placeQueryRepository,
                             PlaceTagsQueryService placeTagsQueryService,
                             CategoryQueryService categoryQueryService,
                             CityQueryService cityQueryService,
                             DongQueryService dongQueryService){
        this.placeMapper = placeMapper;
        this.placeQueryRepository = placeQueryRepository;
        this.placeTagsQueryService = placeTagsQueryService;
        this.categoryQueryService = categoryQueryService;
        this.cityQueryService = cityQueryService;
        this.dongQueryService = dongQueryService;
    }

    public List<PlaceDTO> findPlaceByKeyword(String keyword){
        List<SearchPlace> noPlaceList = placeMapper.searchPlace(keyword);
        if (noPlaceList == null) {
            return new ArrayList<>();
        }
        List<PlaceDTO> placeList = new ArrayList<>();
        int num = noPlaceList.size() - 1;
        for (int i = 0; i <= num; i++) {
            placeList.add(new PlaceDTO(noPlaceList.get(i).getPlaceNo(),
                    noPlaceList.get(i).getPlaceName(),
                    categoryQueryService.findCategoryNameByCategoryNo(noPlaceList.get(i).getCategoryNo()),
                    noPlaceList.get(i).getCityNo(),
                    noPlaceList.get(i).getDongNo(),
                    noPlaceList.get(i).getIntroduction(),
                    noPlaceList.get(i).getPhoneNumber(),
                    noPlaceList.get(i).getLatitude(),
                    noPlaceList.get(i).getLongitude(),
                    noPlaceList.get(i).getPostCode(),
                    noPlaceList.get(i).getPlaceAddress(),
                    noPlaceList.get(i).getRoadPlaceAddress(),
                    noPlaceList.get(i).getImagePath(),
                    noPlaceList.get(i).getThumbnailPath(),
                    noPlaceList.get(i).getAverageStarPoint(),
                    noPlaceList.get(i).getReviewCount()));
        }

        return placeList;
    }

    public ResponsePlaceDTO findPlaceWithTagsByPlaceNo(Long placeNo) {
        Place findedPlace = placeQueryRepository.findByPlaceNo(placeNo);
        if (findedPlace == null) {
            return new ResponsePlaceDTO();
        }
        CategoryDTO category = categoryQueryService.findCategoryByCategoryNo(findedPlace.getCategoryVO().getCategoryNo());
        CityDTO city = cityQueryService.findCityByCityNo(findedPlace.getCityVO().getCityNo());
        DongDTO dong = dongQueryService.findDongByDongNo(findedPlace.getDongVO().getDongNo());
        List<String> tagsList = placeTagsQueryService.findPlaceTagsListByPlaceNo(placeNo);

        return new ResponsePlaceDTO(
                findedPlace.getPlaceNo(),
                findedPlace.getPlaceName(),
                category.getCategoryName(),
                city.getCityName(),
                dong.getDongName(),
                findedPlace.getIntroduction(),
                findedPlace.getPhoneNumber(),
                findedPlace.getCoordinateVO().getLatitude(),
                findedPlace.getCoordinateVO().getLongitude(),
                findedPlace.getPostCode(),
                findedPlace.getPlaceAddress(),
                findedPlace.getRoadPlaceAddress(),
                findedPlace.getImagePath(),
                findedPlace.getThumbnailPath(),
                findedPlace.getAverageStarPoint(),
                findedPlace.getReviewCount(),
                tagsList
        );

    }
}
