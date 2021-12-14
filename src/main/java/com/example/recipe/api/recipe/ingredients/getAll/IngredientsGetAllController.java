package com.example.recipe.api.recipe.ingredients.getAll;

import com.example.recipe.api.recipe.Ingredient;
import com.example.recipe.api.recipe.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IngredientsGetAllController {

    private IngredientsService ingredientsService;

    @Autowired
    public IngredientsGetAllController(IngredientsService ingredientsService) {
        this.ingredientsService = ingredientsService;
    }

    @PostMapping(value = "/api/recipe/ingredients/getAll")
    public ResponseEntity getAll() {
        IngredientsGetAllApiResponse response = new IngredientsGetAllApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        response.setIngredientList(ingredientsService.getAll());
        if (!response.getIngredientList().isEmpty()) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity(response, status);
    }

}
