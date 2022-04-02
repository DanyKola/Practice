package com.company;

public class Kava implements Preparable{
    @Override
    public String getName() {
        return "Káva";
    }

    @Override
    public String getIngredients() {
        return "Káva se vyrábí z kávového prášku a vody.";
    }
}
