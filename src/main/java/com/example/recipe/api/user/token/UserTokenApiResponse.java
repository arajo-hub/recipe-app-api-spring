package com.example.recipe.api.user.token;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserTokenApiResponse {

    private String token;

    public UserTokenApiResponse(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserTokenApiResponse{" +
                "token='" + token + '\'' +
                '}';
    }
}
