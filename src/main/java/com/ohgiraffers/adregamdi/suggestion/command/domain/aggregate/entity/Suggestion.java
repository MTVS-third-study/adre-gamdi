package com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.entity;


import com.ohgiraffers.adregamdi.suggestion.command.domain.aggregate.vo.UserNo;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "TBL_SUGGESTION")
public class Suggestion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long suggestionNo;


    @Embedded
    private UserNo userNo;

    @Column
    private String placeName;

    @Column
    private String postCode;

    @Column
    private String roadAddress;

    @Column
    private String address;

    @Column
    private String detailAddress;

    @Column
    private String phoneNumber;

    @Column
    private String suggestionMessage;


    public Suggestion(UserNo userNo, String placeName, String postCode,
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
