package com.ohgiraffers.adregamdi;

import com.ohgiraffers.adregamdi.user.command.domain.aggregate.vo.UserVO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserTests {
    @Test
    @DisplayName("UserVO 동등 객체 판단 테스트")
    void equalTest() {
        UserVO userDTO1 = UserVO.builder()
                .id(1)
                .nickname("q")
                .email("q")
                .gender("q")
                .build();
        UserVO userDTO2 = UserVO.builder()
                .id(1)
                .nickname("q")
                .email("q")
                .gender("q")
                .build();

        boolean compare = userDTO1.equals(userDTO2);

        Assertions.assertTrue(compare);
    }
}
