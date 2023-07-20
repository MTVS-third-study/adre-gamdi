package com.ohgiraffers.adregamdi;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Objects;

@SpringBootTest
class AdreGamdiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public static void main(String[] args) {

        Object userNo = 1L;
        Long userNom = Long.valueOf(String.valueOf(userNo));
        System.out.println("userNom = " + userNom);
    }

}
