package com.company;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.*;

import static java.util.Collections.*;

public class StatyDPH {

    //1. Načti ze souboru všechna data do vhodné datové struktury (vytvoř třídu pro uložení dat).
    public static final String DELIMETR = "\t";
    public static final String FILE_NAME = "vat-eu.csv";

    private List<Staty> statyList = new ArrayList<>();

    public void loadFromFile(String FileName, String DELIMETR) {
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));) {
            while (scanner.hasNext()) {
                String inputLine = scanner.nextLine();
                String[] parts = inputLine.split(DELIMETR);
                String zkratkaStatu = parts[0];
                String nazevStatu = parts[1];
                int plnaSazbaDPH = Integer.parseInt(parts[2]);
                String ssPH = parts[3].replace(",", ".");
                double snizenaSazbaDPH = Double.parseDouble(ssPH);
                boolean specialniDPH = Boolean.parseBoolean(parts[4]);


                Staty staty = new Staty(zkratkaStatu, nazevStatu, plnaSazbaDPH, snizenaSazbaDPH, specialniDPH);
                statyList.add(staty);
                //Collections.sort(statyList, new SceneComparator());

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Špatně zadané číslo" + e.getLocalizedMessage());
        }

    }

    //6. Výsledný výpis zapiš také do souboru s názvem vat-over-20.txt. Výstupní soubor ulož do stejné složky, ve které byl vstupní soubor. (Výpis na obrazovku zůstává.)
    public void saveToFile(String fileName, String DELIMETR) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Staty s : statyList) {
                String outputLine = s.getZkratkaStatu() + DELIMETR;
                outputLine += s.getNazevStatu() + DELIMETR;
                outputLine += s.getPlnaSazbaDPH() + DELIMETR;
                outputLine += s.getSnizenaSazbaDPH() + DELIMETR;
                outputLine += s.isSpecialniDPH() + "\n";
                writer.print(outputLine);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Staty> getStatykopii() {
        return new ArrayList<>(statyList);
    }


    public void compareTo() {
        Collections.sort(statyList, new SceneComparator());
    }



}