package com.anna.tgBot.yaml;

import java.util.List;

public class DataWrapper {

    private List<CategoryData> categories;
    private List<ClientData> clients;

    public List<CategoryData> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryData> categories) {
        this.categories = categories;
    }

    public List<ClientData> getClients() {
        return clients;
    }

    public void setClients(List<ClientData> clients) {
        this.clients = clients;
    }
}
