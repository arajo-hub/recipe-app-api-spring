package com.example.recipe.api.recipe.recipes;

import com.example.recipe.api.recipe.Recipe;
import com.example.recipe.api.recipe.RecipesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeRecipesController {

    private RecipesService recipesService;

    public RecipeRecipesController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping(value = "/api/recipe/recipes", produces = "application/json")
    public ResponseEntity recipes(@RequestBody Recipe recipe) {
        System.out.println(recipe);
        RecipeRecipesApiResponse response = new RecipeRecipesApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        status = recipesService.addRecipe(recipe);
        response.setRecipe(recipe);
        return new ResponseEntity(response, status);
    }

}
