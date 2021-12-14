package com.example.recipe.api.recipe.tags.getAll;

import com.example.recipe.api.recipe.TagsService;
import com.example.recipe.api.recipe.ingredients.getAll.IngredientsGetAllApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TagsGetAllController {

    private TagsService tagsService;

    @Autowired
    public TagsGetAllController(TagsService tagsService) {
        this.tagsService = tagsService;
    }

    @PostMapping(value = "/api/recipe/tags/getAll")
    public ResponseEntity getAll() {
        TagsGetAllApiResponse response = new TagsGetAllApiResponse();
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        response.setTagList(tagsService.getAll());
        if (!response.getTagList().isEmpty()) {
            status = HttpStatus.OK;
        } else {
            status = HttpStatus.NO_CONTENT;
        }
        return new ResponseEntity(response, status);
    }

}
