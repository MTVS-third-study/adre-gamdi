package com.ohgiraffers.adregamdi.user.command.domain.exception;

import com.google.gson.JsonObject;

public class UserException {
    public String solveNullPointerException(String element, JsonObject kakao_account) {
        String result;

        try {
            if ("".equals(kakao_account.getAsJsonObject().get(element).getAsString())
                    || kakao_account.getAsJsonObject().get(element).getAsString() == null) {
                throw new NullPointerException();
            }
            result = kakao_account.getAsJsonObject().get(element).getAsString();

        } catch (NullPointerException ne) {
            ne.printStackTrace();
            result = "";
        }
        return result;
    }
}
