package com.example.recipe.api.common;

import lombok.Getter;

public class ResponseEnum {

    @Getter
    public enum ResponseCode {
        SUCCESS("0000", "Success"),
        FAIL("9999", "Fail");

        private String code;
        private String message;

        ResponseCode(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}