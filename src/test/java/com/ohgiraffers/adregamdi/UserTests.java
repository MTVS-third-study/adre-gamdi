package com.ohgiraffers.adregamdi;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    @DisplayName("UserVO 동등 객체 판단 테스트")
    void equalTest() {
        UserVO userVO1 = UserVO.builder()
                .id("1")
                .kakaoNickName("q")
                .serviceNickName("q")
                .email("q")
                .gender("q")
                .build();
        UserVO userVO2 = UserVO.builder()
                .id("1")
                .kakaoNickName("q")
                .serviceNickName("q")
                .email("q")
                .gender("q")
                .build();

        boolean compare = userVO1.equals(userVO2);

        Assertions.assertTrue(compare);
    }
}
