package com.example.recipe.api.user.create;

import com.example.recipe.api.user.User;
import com.example.recipe.api.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class UserCreateController {

    private UserService userService;

    @Autowired
    public UserCreateController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/api/user/create", produces = "application/json")
    public ResponseEntity create(@RequestBody User user) {
        UserCreateApiResponse response = new UserCreateApiResponse(null);
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if (user.hasMeaningfulValues()) {
            status = userService.validateUser(user);
            if (status.equals(HttpStatus.OK)) {
                status = userService.createUser(user);
                if (status.equals(HttpStatus.OK)) {
                    response.setUser(user);
                    status = HttpStatus.CREATED;
                }
            }
        } else {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);

    }
}

