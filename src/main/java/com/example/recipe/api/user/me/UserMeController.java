package com.example.recipe.api.user.me;

import com.example.recipe.api.user.User;
import com.example.recipe.api.user.UserIncludeToken;
import com.example.recipe.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserMeController {

    private UserService userService;

    @Autowired
    public UserMeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/user/me", produces = "application/json")
    public ResponseEntity me(@RequestBody UserIncludeToken userAndToken) {
        UserMeApiResponse response = new UserMeApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if (userAndToken.hasMeaningfulValues()) {
            status = userService.validateUser(userAndToken);
            if (status.equals(HttpStatus.OK)) {
                status = userService.replaceUser(userAndToken);
                if (status.equals(HttpStatus.OK)) {
                    response.setUser(userAndToken);
                    status = HttpStatus.CREATED;
                }
            }
        }
        return new ResponseEntity<>(response, status);
    }

}
