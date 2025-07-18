package com.anna.tgBot.yaml;

import java.util.List;

public class CategoryData {
    private String name;

    public List<SubcategoryData> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubcategoryData> subcategories) {
        this.subcategories = subcategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<SubcategoryData> subcategories;


}
