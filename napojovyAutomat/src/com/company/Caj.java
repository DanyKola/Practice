package com.company;

public class Caj implements Preparable {


    @Override
    public String getName() {
        return "Čaj";
    }

    @Override
    public String getIngredients() {
        return "Čaj se skládá ze sirupu a vody.";
    }
}
