package com.example.recipe.api.recipe.tags.getAll;

import com.example.recipe.api.recipe.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TagsGetAllApiResponse {

    private List<Tag> tagList;

}
