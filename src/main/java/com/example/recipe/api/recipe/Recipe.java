package com.example.recipe.api.recipe;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Recipe {

    private String title;
    private String ingredient;
    private String tag;
    private int time;
    private int price;
    private String url;

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", ingredient='" + ingredient + '\'' +
                ", tag='" + tag + '\'' +
                ", time=" + time +
                ", price=" + price +
                ", url='" + url + '\'' +
                '}';
    }
}
