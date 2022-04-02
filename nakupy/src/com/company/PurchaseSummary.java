package com.company;

import java.io.*;
import java.math.BigDecimal;
import java.net.BindException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.company.Main.DELIMETR;

public class PurchaseSummary {
    List<PurchaseNakup> purchaseNakupList = new ArrayList<>();

//Načetení ze souboru
    public void loadFromFile(String FileName, String delimetr){
        //Try -with -resources
        try (Scanner scanner = new Scanner(new BufferedReader(new FileReader("Purchase.txt")));){

        //teď jsme soubor načetli a musíme ho přešíst
        //musím se scanneru zeptat, zda tam vůbec nějaký řádek je. A protože nevím kolik těch řádků bude obalím to do cyklu
        //while aby četl dokud bude co.
            while (scanner.hasNext()){ //je tam nějaký další řádek v tom souboru?
                //System.out.println(scanner.nextLine()); //vypiš jednoduše
                //Teď vypsat jednotlivé úseky a udělat z nich objekty
                //Zatím je to jeden veliký textový řetězec
                String inputLine = scanner.nextLine();
                //System.out.println(Arrays.toString(parts)); //vypsat
                //rozdělit vstupní řádek na pole testových řetězců
                String[] parts = inputLine.split(delimetr); //předtím tam bylo inputLine.split(";")
                //Z textových polí vyrobit jednotlivé součásti toho objektu
                LocalDate date = LocalDate.parse(parts[0]); //udělej z indexu 0 LocalDate
                double priceDouble = Double.parseDouble(parts[1]); //musím si nejprve převést na double a pak na BigDecimal
                BigDecimal price = BigDecimal.valueOf(priceDouble);
                Category category = Category.valueOf(parts[2]);
                String desription = parts[3];

                //Z dílčích objektů si vytvořím objekt třídy Purchase - poskládám si je a přidám ho do listu
                PurchaseNakup nakup = new PurchaseNakup(desription, category, price, date);
                purchaseNakupList.add(nakup);

            }
        } //práce se soubory a přidané výjimky
        catch (IOException | NumberFormatException e){ //kombinovaná výjimka
            e.printStackTrace();
        } catch (DateTimeException e){ //tento je detailnější
            System.out.println("Špatně zadané datum "+e.getLocalizedMessage() );
        }
        //chytí všechny
        //(Exception e){..}
    }

//METODA - Možnost získat seznam nákupů, které byly provedeny po zadaném datu.


//METODA - Možnost přidání nového nákupu
    public void addPurchase(PurchaseNakup newPuchaseNakup ){
        purchaseNakupList.add(newPuchaseNakup);
    }

//METODA - Možnost odstranění zadaného nákupu
    public void removePurchaseNakup (PurchaseNakup purchaseNakup){
        purchaseNakupList.remove(purchaseNakup);
    }
//METODA - celkovou cenu všech nákupů
        public BigDecimal getSoucetPurchseNakup(){
            BigDecimal suma = BigDecimal.ZERO;
            for (PurchaseNakup p : purchaseNakupList){
                suma = suma.add(p.getPrice());
            }
            return suma;
        }

//METODA - počet všech nákupů
    public int sizePurchseNakupu(){
        return purchaseNakupList.size();

    }
//METODA průměrná cena nákupu
    //divide - nutné když počítám s BigDecimal
    /*
     public BigDecimal getPrumernaCenaNakupu() {
        return getSoucetPurchseNakup().divide(BigDecimal.valueOf(sizePurchseNakupu()));
    }
     */

//Nutné dodat výjimky, protože když dělím 0 tzn. metodu spustím před prvním nákupem, program spadne.
        public BigDecimal getPrumernaCenaNakupu() throws Exception {
            if (sizePurchseNakupu()==0){
                throw new Exception(
                // RunTimeException - když nejde pokračovat
                //a
                // Exception je hlídaná výjimka - se používá upozornit uživatele, vyžádat si opravu, nechat si zadat novou hodnotu....
                //Tady v té části kodu napíšeme takto, že nastal chybový stav a ještě nevíme jak uživatele upozornit,...
                //= nastal chybový stav a popíšeme jaký
                //Celé je to červeně podtržené, tak červená žárovka add ...a u názvu se objeví throws Exception.Druhá červená varianta je zpracování try cash, ale to v této fázi nechceme

                "Nelze počítat průměrnou cenu, když v kolekci nejsou žádné položky");
            }
            return getSoucetPurchseNakup().divide(BigDecimal.valueOf(sizePurchseNakupu()));
        }
    //Metoda, která nám bude vracet ten list
    public List<PurchaseNakup> getAllPurchaseNakupList() {
            //Vytvořím kopii listu a tu poskytnu jako výsledek volání
        return new ArrayList<>(purchaseNakupList);
    }
    //METODA zápisu do souboru
    public void saveToFile(String fileName, String delimetr) {
            try(PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            //postupně brát jednotlivé položky ze seznamu
            //+ si vytvořím konstantu delimetr (tak jako u FILE_NAME)
                for (PurchaseNakup p : purchaseNakupList){
                    String outPutLine = p.getPurchaseDate().toString()+delimetr;
                    outPutLine += p.getPrice().toString()+delimetr;
                    outPutLine += p.getCategory().toString()+delimetr;
                    outPutLine += p.getDescription();
                    writer.println(outPutLine); //Zápis do souboru
                }


            } catch (IOException e){
                e.printStackTrace();
            }
    }
}
