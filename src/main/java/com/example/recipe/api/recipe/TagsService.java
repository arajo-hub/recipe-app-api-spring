package com.example.recipe.api.recipe;

import com.example.recipe.api.recipe.Tag;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface TagsService {

    HttpStatus addTag(Tag tag);

    List<Tag> getAll();
}
