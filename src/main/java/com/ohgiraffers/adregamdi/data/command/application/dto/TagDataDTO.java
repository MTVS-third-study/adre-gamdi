package com.ohgiraffers.adregamdi.data.command.application.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TagDataDTO {

    /* 태그 */
    private List<String> tagList;
}
