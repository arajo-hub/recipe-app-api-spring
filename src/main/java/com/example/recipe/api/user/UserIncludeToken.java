package com.example.recipe.api.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;

@Getter
@Setter
public class UserIncludeToken extends User {

    private String token;

    @Override
    public boolean hasMeaninglessValues() {
        return this == null || (super.hasMeaninglessValues() && ObjectUtils.isEmpty(this.token));
    }

}
