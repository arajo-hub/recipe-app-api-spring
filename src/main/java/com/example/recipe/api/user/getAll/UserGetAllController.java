package com.example.recipe.api.user.getAll;

import com.example.recipe.api.user.Token;
import com.example.recipe.api.user.UserIncludeToken;
import com.example.recipe.api.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserGetAllController {

    private UserService userService;

    @Autowired
    public UserGetAllController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/api/user/getAll", produces = "application/json")
    public ResponseEntity getAll(@RequestBody Token token) {
        UserGetAllApiResponse response = new UserGetAllApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        response.setUserList(userService.getAll(token.getToken()));
        if (!response.getUserList().isEmpty()) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(response, status);
    }

}
