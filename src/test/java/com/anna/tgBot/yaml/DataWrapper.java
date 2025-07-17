package com.anna.tgBot.yaml;

import java.util.List;

public class DataWrapper {
    private List<CategoryData> categories;

    public List<CategoryData> getCategories() {
        return categories;
    }
    public List<ClientData> getClients() { return clients; }
    public void setClients(List<ClientData> clients) { this.clients = clients; }

    public void setCategories(List<CategoryData> categories) {
        this.categories = categories;
    }
}

