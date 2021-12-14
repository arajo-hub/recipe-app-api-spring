package com.example.recipe.api.recipe;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface RecipesService {

    HttpStatus addRecipe(Recipe recipe);

    List<Recipe> getAll();
}
