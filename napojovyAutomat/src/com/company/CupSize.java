package com.company;

public enum CupSize {
//Dále bude automat nabízet metodu setCupSize. Ta dostane jako parametr instanci výčtového typu (enum) CupSize.

    BIG("velký"), SMALL("malý");
    private final String description;

    public String getDescription() {
        return description;
    }

    private CupSize(String description) {
        this.description = description;
    }
}

