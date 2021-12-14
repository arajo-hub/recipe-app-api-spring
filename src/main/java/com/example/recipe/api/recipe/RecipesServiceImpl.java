package com.example.recipe.api.recipe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipesServiceImpl implements RecipesService {

    private static List<Recipe> recipeRepository = new ArrayList<>();
    private IngredientsService ingredientsService;
    private TagsService tagsService;

    @Autowired
    public RecipesServiceImpl(IngredientsService ingredientsService, TagsService tagsService) {
        this.ingredientsService = ingredientsService;
        this.tagsService = tagsService;
    }

    @Override
    public HttpStatus addRecipe(Recipe recipe) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        List<Ingredient> ingredientList = ingredientsService.getAll();
        List<Tag> tagList = tagsService.getAll();
        boolean isInIngredientList = false;
        for (Ingredient ingredient : ingredientList) {
            if (recipe.getIngredient().equals(ingredient.getName())) {
                isInIngredientList = true;
            }
        }
        boolean isInTagList = false;
        for (Tag tag : tagList) {
            if (recipe.getTag().equals(tag.getName())) {
                isInTagList = true;
            }
        }

        if (recipe.getTitle().length() > 255 || isInIngredientList == false || isInTagList == false) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            if (recipeRepository.add(recipe)) {
                status = HttpStatus.OK;
            }
        }
        return status;
    }

    @Override
    public List<Recipe> getAll() {
        return this.recipeRepository;
    }
}
