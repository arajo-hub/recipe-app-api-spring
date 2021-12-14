package com.example.recipe.api.recipe;

import com.example.recipe.api.recipe.Tag;
import com.example.recipe.api.recipe.TagsService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagsServiceImpl implements TagsService {

    private static List<Tag> tagRepository = new ArrayList<>();

    @Override
    public HttpStatus addTag(Tag tag) {
        HttpStatus status = HttpStatus.EXPECTATION_FAILED;
        if (tag.getName().length() > 255) {
            status = HttpStatus.BAD_REQUEST;
        } else {
            if (tagRepository.add(tag)) {
                status = HttpStatus.OK;
            }
        }
        return status;
    }

    @Override
    public List<Tag> getAll() {
        return this.tagRepository;
    }

}
