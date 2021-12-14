package com.example.recipe.api.user;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface UserService {

    HttpStatus validateUser(User user);

    HttpStatus createUser(User user);

    HttpStatus login(User user);

    HttpStatus saveToken(User user);

    String getToken(User user);

    HttpStatus replaceUser(UserIncludeToken user);

    List<User> getAll(String token);
}
