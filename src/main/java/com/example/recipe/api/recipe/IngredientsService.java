package com.example.recipe.api.recipe;

import org.springframework.http.HttpStatus;

import java.util.List;

public interface IngredientsService {

    HttpStatus addIngredient(Ingredient ingredient);

    List<Ingredient> getAll();
}
