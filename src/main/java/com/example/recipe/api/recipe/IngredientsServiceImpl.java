package com.example.recipe.api.recipe;

import com.example.recipe.api.user.User;
import lombok.var;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientsServiceImpl implements IngredientsService {

    private static List<Ingredient> ingredientRepository = new ArrayList<>();

    @Override
    public HttpStatus addIngredient(Ingredient ingredient) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if (ingredient.getName().length() > 255) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            if (ingredientRepository.add(ingredient)) {
                status = HttpStatus.OK;
            }
        }
        return status;
    }

    @Override
    public List<Ingredient> getAll() {
        return this.ingredientRepository;
    }

}
