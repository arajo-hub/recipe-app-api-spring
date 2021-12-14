package com.example.recipe.api.recipe.ingredients;

import com.example.recipe.api.recipe.Ingredient;
import com.example.recipe.api.recipe.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeIngredientsController {

    private IngredientsService ingredientsService;

    @Autowired
    public RecipeIngredientsController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping(value = "/api/recipe/ingredients", produces = "application/json")
    public ResponseEntity ingredients(@RequestBody Ingredient ingredient) {
        RecipeIngredientsApiResponse response = new RecipeIngredientsApiResponse();
        HttpStatus status = ingredientsService.addIngredient(ingredient);
        if (status.equals(HttpStatus.OK)) {
            response.setIngredient(ingredient);
        }
        return new ResponseEntity(response, status);
    }

}
