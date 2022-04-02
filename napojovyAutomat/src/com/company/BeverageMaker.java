package com.company;

import java.util.ArrayList;
import java.util.List;

public class BeverageMaker {
    private CupSize selectedCupSize = CupSize.SMALL;

//Bude nabízet metody addBeverage. Jako parametr dostane popis nápoje (instanci třídy, splňující rozhraní Preparable).
    public void addBeverage(Preparable beverage) {
        beverages.add(beverage);
    }

//Instanci uloží do vhodné kolekce.
    ArrayList<Preparable> beverages = new ArrayList<>();



//K výrobě nápojů bude sloužit metoda prepare.
//Protože hardware k dispozici nemáme, budeme nám třída jen vracet text,
// který by se zobrazoval na displeji automatu. My si ho vypíšeme na obrazovku.

    public String prepare(int type){
        String result = "";

        if (type >= beverages.size()) return "Tento nápoj není k dispozici!";

        Preparable selectedBeverage = beverages.get(type);
        result += "Připravuji " + selectedCupSize.getDescription() + " šálek";
        result += " - " + selectedBeverage.getName();
        result += " - " + selectedBeverage.getIngredients();
        return result;

    }




//Dále bude automat nabízet metodu setCupSize. Ta dostane jako parametr instanci výčtového typu (enum) CupSize.
    public void setCupSize(CupSize size){
        selectedCupSize = size;
    }
}
