package com.example.recipe.api.user.token;

import com.example.recipe.api.user.UserService;
import com.example.recipe.api.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserTokenController {

    private UserService userService;

    @Autowired
    public UserTokenController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/user/token", produces = "application/json")
    public ResponseEntity token(@RequestBody User user) {
        UserTokenApiResponse response = new UserTokenApiResponse(null);
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        // 로그인
        if (userService.login(user).equals(HttpStatus.OK)) {
            status = userService.saveToken(user);
            if (status.equals(HttpStatus.OK)) {
                response.setToken(userService.getToken(user));
                status = HttpStatus.OK;
            }
        } else {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

}
