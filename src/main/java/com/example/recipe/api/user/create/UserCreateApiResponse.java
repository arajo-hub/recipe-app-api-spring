package com.example.recipe.api.user.create;

import com.example.recipe.api.user.User;
import lombok.Getter;

@Getter
public class UserCreateApiResponse {

    private User user;

    public UserCreateApiResponse(User user) {
        this.user = user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserCreateApiResponse{" +
                "user=" + user +
                '}';
    }
}