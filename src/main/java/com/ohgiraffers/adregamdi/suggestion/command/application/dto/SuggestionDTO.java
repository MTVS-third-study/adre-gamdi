package com.ohgiraffers.adregamdi.suggestion.command.application.dto;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SuggestionDTO {

    private Long suggestionNo;

    private Long userNo;

    private String suggestionMessage;

    public SuggestionDTO(Long userNo, String suggestionMessage) {
        this.userNo = userNo;
        this.suggestionMessage = suggestionMessage;
    }
}
