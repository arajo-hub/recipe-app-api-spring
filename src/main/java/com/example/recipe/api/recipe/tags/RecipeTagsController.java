package com.example.recipe.api.recipe.tags;

import com.example.recipe.api.recipe.Tag;
import com.example.recipe.api.recipe.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeTagsController {

    private com.example.recipe.api.recipe.TagsService TagsService;

    @Autowired
    public RecipeTagsController(TagsService tagsService) {
        this.TagsService = tagsService;
    }

    @PostMapping(value = "/api/recipe/tags", produces = "application/json")
    public ResponseEntity ingredients(@RequestBody Tag tag) {
        RecipeTagsApiResponse response = new RecipeTagsApiResponse();
        HttpStatus status = TagsService.addTag(tag);
        if (status.equals(HttpStatus.OK)) {
            response.setTag(tag);
        }
        return new ResponseEntity(response, status);
    }

}
