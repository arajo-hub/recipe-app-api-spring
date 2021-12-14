package com.example.recipe.api.recipe.ingredients.getAll;

import com.example.recipe.api.recipe.Ingredient;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IngredientsGetAllApiResponse {

    private List<Ingredient> ingredientList;

}
