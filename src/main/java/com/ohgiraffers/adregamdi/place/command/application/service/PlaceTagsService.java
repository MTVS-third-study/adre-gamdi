package com.ohgiraffers.adregamdi.place.command.application.service;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.Place;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.entity.PlaceTags;
import com.ohgiraffers.adregamdi.place.command.domain.aggregate.vo.TagVO;
import com.ohgiraffers.adregamdi.place.command.domain.repository.PlaceTagsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaceTagsService {

    private final PlaceTagsRepository placeTagsRepository;

    @Autowired
    public PlaceTagsService(PlaceTagsRepository placeTagsRepository) {
        this.placeTagsRepository = placeTagsRepository;
    }
    public Long insertPlaceAndTags(PlaceTagsDTO placeTagsDTO) {
        PlaceTags result = placeTagsRepository.save(new PlaceTags(
                new Place(placeTagsDTO.getPlaceNo()),
                new TagVO(placeTagsDTO.getTagNo())
        ));
        return result.getPlaceTagsNo();
    }
}
