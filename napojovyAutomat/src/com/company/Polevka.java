package com.company;

public class Polevka implements Preparable{

    @Override
    public String getName() {
        return "Polévka";
    }

    @Override
    public String getIngredients() {
        return "Polévka se připravuje z polévkového prášku, instantních těstovin a vody.";
    }
}
