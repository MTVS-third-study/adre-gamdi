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

    private String placeName;

    private String postCode;

    private String roadAddress;

    private String address;

    private String detailAddress;

    private String phoneNumber;

    private String suggestionMessage;

    public SuggestionDTO(Long userNo, String placeName, String postCode,
                         String roadAddress, String address, String detailAddress,
                         String phoneNumber, String suggestionMessage) {
        this.userNo = userNo;
        this.placeName = placeName;
        this.postCode = postCode;
        this.roadAddress = roadAddress;
        this.address = address;
        this.detailAddress = detailAddress;
        this.phoneNumber = phoneNumber;
        this.suggestionMessage = suggestionMessage;
    }
}
