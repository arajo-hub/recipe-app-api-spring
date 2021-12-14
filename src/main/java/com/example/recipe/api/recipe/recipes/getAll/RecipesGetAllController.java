package com.example.recipe.api.recipe.recipes.getAll;

import com.example.recipe.api.recipe.Recipe;
import com.example.recipe.api.recipe.RecipesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipesGetAllController {

    private RecipesService recipesService;

    public RecipesGetAllController(RecipesService recipesService) {
        this.recipesService = recipesService;
    }

    @PostMapping
    public ResponseEntity getAll() {
        RecipesGetAllApiResponse response = new RecipesGetAllApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        List<Recipe> recipeList = recipesService.getAll();
        return new ResponseEntity(response, status);
    }

}
