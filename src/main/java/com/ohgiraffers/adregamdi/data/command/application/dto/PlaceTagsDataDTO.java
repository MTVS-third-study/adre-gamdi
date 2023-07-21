package com.ohgiraffers.adregamdi.data.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlaceTagsDataDTO {

    private Long placeNo;
    /* 태그 */
    private Long tagNo;
}
