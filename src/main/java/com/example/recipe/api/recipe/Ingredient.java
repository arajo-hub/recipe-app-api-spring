package com.example.recipe.api.recipe;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Ingredient {

    private String name;

    public Ingredient(String ingredientName) {
        this.name = ingredientName;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "name='" + name + '\'' +
                '}';
    }
}
