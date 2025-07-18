package com.anna.tgBot.yaml;

import java.util.List;

public class SubcategoryData {
    private String name;
    private List<ProductData> products;

    public SubcategoryData(String name, List<ProductData> products) {
        this.name = name;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ProductData> getProducts() {
        return products;
    }

    public void setProducts(List<ProductData> products) {
        this.products = products;
    }
}
