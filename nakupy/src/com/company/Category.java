package com.company;

public enum Category {
    FOOD ("jídlo"),
    CONSUMABLES ("spotřební materiál"),
    OTHERS ("ostatní");

    private String description;

    Category(String description) {
        this.description = description;
    }


}
