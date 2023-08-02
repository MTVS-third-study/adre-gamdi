package com.ohgiraffers.adregamdi.place.query.application.service;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.PlaceTags;
import com.ohgiraffers.adregamdi.place.query.infra.repository.PlaceTagsQueryRepository;
import com.ohgiraffers.adregamdi.tag.query.application.service.TagQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PlaceTagsQueryService {

    private final PlaceTagsQueryRepository placeTagsQueryRepository;
    private final TagQueryService tagQueryService;

    @Autowired
    public PlaceTagsQueryService(PlaceTagsQueryRepository placeTagsQueryRepository,
                                 TagQueryService tagQueryService) {
        this.placeTagsQueryRepository = placeTagsQueryRepository;
        this.tagQueryService = tagQueryService;
    }

    public List<String> findPlaceTagsListByPlaceNo(Long placeNo) {
        List<Long> placeTagsList = null;
        try {
            placeTagsList = placeTagsQueryRepository.findAllByPlaceNo(placeNo);
            if (placeTagsList == null) {
                new ArrayList<>();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return placeTagsList.stream().map(tagNo -> tagQueryService.findTagNameByTagNo(tagNo)).collect(Collectors.toList()); // map 후 collect를 사용하여 리스트로 변환
    }

}
