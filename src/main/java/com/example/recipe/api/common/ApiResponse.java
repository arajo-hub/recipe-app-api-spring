package com.example.recipe.api.common;

import com.example.recipe.api.common.ResponseEnum.ResponseCode;
import org.apache.catalina.connector.Response;

public class ApiResponse extends Response {

    private String resultCode;
    private String resultMessage;

    public ApiResponse(ResponseCode responseCode) {
        this.resultCode = responseCode.getCode();
        this.resultMessage = responseCode.getMessage();
    }

    public void setResult(ResponseCode responseCode) {
        this.resultCode = responseCode.getCode();
        this.resultMessage = responseCode.getMessage();
    }
}
