package com.company;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PomocnaTrida {


    public class Main {

        public static final String FILE_NAME = "vat-eu.csv";
        public static final String DELIMETR = "\t";
        List<Staty> result = new ArrayList<Staty>();
        //public static final String VYSTUP_TXT = "vat-over-20.txt";



        //2. Vypiš seznam všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:
        public static void main(String[] args) throws StateException {


            StatyDPH statyDPH = new StatyDPH();
            try {
                statyDPH.loadFromFile(FILE_NAME, DELIMETR);
            } catch (Exception e) {
                System.err.println(e.getLocalizedMessage());
            }
            System.out.println("------------------------------------");
            System.out.println("KOMPLETNÍ VÝPIS všech států a u každého uveď základní sazbu daně z přidané hodnoty ve formátu podle vzoru:");
            System.out.println("------------------------------------");
            for (Staty p : statyDPH.getStatykopii()) {

                System.out.println(p.getNazevStatu() + " (" + p.getZkratkaStatu() + "): " + p.getPlnaSazbaDPH() + " %");

            }
            System.out.println("------------------------------------");

//7. Doplň možnost, aby uživatel z klávesnice zadal výši sazby DPH/VAT, podle které se má filtrovat. Vypíší se tedy státy se základní sazbou vyšší než ta, kterou uživatel zadal.
            Scanner sc = new Scanner(System.in);
            System.out.println("Zadej výši DPH:");
            System.out.println("------------------------------------");
            String volba = sc.nextLine() ;
            int volbaFinal = 0;
            if (volba.equals("")){
                //
                volbaFinal = 20;

            } else {
                volbaFinal = Integer.parseInt(volba);
            }
            System.out.println("Nyní vygenerujeme všechny státy s vyšší DPH než je vložených: "+volbaFinal);
            try {

                String name = "vat-over-"+volbaFinal+".txt";
                File myObj = new File(name);
                if (myObj.createNewFile()) {
                    System.out.println("Vytvořen soubor: " + myObj.getName());
                } else {
                    System.out.println("Soubor již existuje");
                }
            } catch (IOException e) {
                System.out.println("Vyskytla se chyba");
                e.printStackTrace();
            }

            for (Staty p : statyDPH.getStatykopii()) {
                if (p.getPlnaSazbaDPH() > volbaFinal){
                    System.out.println(p.getNazevStatu() + " (" + p.getZkratkaStatu() + "): " + p.getPlnaSazbaDPH() + " %");
                }

            }

//3. Vypište ve stejném formátu pouze státy, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.
//4. Výpis z bodu 3. seřaď podle výše základní sazby DPH/VAT sestupně (nejprve státy s nejvyšší sazbou).

            System.out.println("------------------------------------");
            System.out.println("VÝPIS VYBRANÝCH POLÍ, které mají základní sazbu daně z přidané hodnoty vyšší než 20 % a přitom nepoužívají speciální sazbu daně.:---------------- ");
            System.out.println("------------------------------------");
            for (Staty p : statyDPH.getStatykopii()) {

                if (p.getPlnaSazbaDPH() > 20 && !p.isSpecialniDPH()) {
                    String format = p.getNazevStatu() + " (" + p.getZkratkaStatu() + "): " + p.getPlnaSazbaDPH() + " %";
                    System.out.println(format);
                }
            }

//5. Pod výpis z bodu 3. doplň řádek s rovnítky pro oddělení a poté seznam zkratek států, které ve výpisu nefigurují. Opět dodrž formát podle vzoru (místo tří teček budou další státy):
            System.out.println("========================================");
            for (Staty p : statyDPH.getStatykopii()) {
                if (p.getPlnaSazbaDPH() > 20 && p.isSpecialniDPH() || p.getPlnaSazbaDPH() <= 20) {
                    System.out.printf(p.getZkratkaStatu()+", ");
                }
            }

//6.Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)

            try {
                statyDPH.saveToFile("vat-over-"+volbaFinal+".txt",DELIMETR);
            } catch (Exception e) {
                System.out.println(e.getLocalizedMessage());
            }

        }
    }






}
