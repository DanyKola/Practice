package com.company;

public enum Payment {
    CASH ("hotově"),
    CARD ("kartou");

    String description;

    Payment(String description) {
        this.description = description;
    }
}
