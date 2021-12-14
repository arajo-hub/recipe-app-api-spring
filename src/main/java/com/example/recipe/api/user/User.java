package com.example.recipe.api.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.Objects;

@Getter
@Setter
public class User {

    private String name;
    private String password;
    private String email;

    /* Need Method */

    public boolean hasMeaninglessValues() {
        return this == null || (ObjectUtils.isEmpty(this.name) && ObjectUtils.isEmpty(this.password) && ObjectUtils.isEmpty(this.email));
    }

    public boolean hasMeaningfulValues() {
        return !hasMeaninglessValues();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) && Objects.equals(password, user.password) && Objects.equals(email, user.email);
    }

}
