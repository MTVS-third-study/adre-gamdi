package com.ohgiraffers.adregamdi.place.query.application.dto;

import com.ohgiraffers.adregamdi.place.command.application.dto.PlaceTagsDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponsePlaceTagsDTO {

    private String placeNo;
    private List<PlaceTagsDTO> placeTagsDTOList;
}
