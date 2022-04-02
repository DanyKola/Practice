package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {

    public static final String FILE_NAME = "purchase.txt";
    public static final String DELIMETR = ";";

    //udělám si nový main, abych mohla číst
    public static void main(String[] args) {
        //Vytvořím si PirchaseSummary
        PurchaseSummary ps = new PurchaseSummary();
        //ps.loadFromFile("purchase.txt"); = vylepši refactorem
        //označit soubor, dát refactor/Introduce contains a přejmenusi dle potřeb
        ps.loadFromFile(FILE_NAME, DELIMETR);

        //vypsat soubor už s přetransformovanými položkami
        for (PurchaseNakup pnakup: ps.getAllPurchaseNakupList()){
            System.out.println(pnakup);
        }
        //Přidám položku
        ps.addPurchase(new PurchaseNakup("Rohlík",Category.FOOD, BigDecimal.valueOf(4.30), LocalDate.of(2022, 03,18) ));

        //uložím do seznamu
        ps.saveToFile(FILE_NAME, DELIMETR);
    }

    public static void mainException(String[] args) {

	PurchaseNakup purchaseNakup1 = new PurchaseNakup("Pečivo",Category.FOOD, BigDecimal.valueOf(548.10), LocalDate.of(2021,8,9));
    PurchaseNakup purchaseNakup2 = new PurchaseNakup("Benzín (28 l)", Category.CONSUMABLES, BigDecimal.valueOf(935.0), LocalDate.of(2021,8,8));

//Vytvoření evidence
        PurchaseSummary purchaseSummary = new PurchaseSummary();
// Přídání nákupu
        purchaseSummary.addPurchase(purchaseNakup1);
        purchaseSummary.addPurchase(purchaseNakup2);

//Výpis počet nákupůů
        System.out.println("Počet nákupů je: "+purchaseSummary.sizePurchseNakupu());
//Výpis částky nákupů
        System.out.println("Suma nákupů je: "+purchaseSummary.getSoucetPurchseNakup());
//Výpis průměrné ceny nákupu
        //Když si stanovým výjimku v PurchaseSummary, podtrhne se mi červeně i getPrumernaCenaNakupu(), protože zde musím výjimku ošetřit
       //červená žárovka a doplním try catch
        try { //když to bude v pohodě, stane se toto
            System.out.println("Průměrná cena nákupu je: "+purchaseSummary.getPrumernaCenaNakupu());
        } catch (Exception e) { //když to nebude v pohodě, stane se toto
            //e.printStackTrace(); //výchozí řešení
            System.err.println("Chyba při výpočtu: " +e.getLocalizedMessage());
            System.out.println("_____konec______");
        }
    }
}
