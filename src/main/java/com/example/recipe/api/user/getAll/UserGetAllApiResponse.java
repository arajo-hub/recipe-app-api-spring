package com.example.recipe.api.user.getAll;

import com.example.recipe.api.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserGetAllApiResponse {

    private List<User> userList;

}
