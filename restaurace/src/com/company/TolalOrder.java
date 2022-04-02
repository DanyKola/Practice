package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class TolalOrder {
//Iniciace Other
    ArrayList<Order> orders = new ArrayList<>();

//Přidání objednávky
    public void addOrder (Order order){
        orders.add(order);
    }

//Počet objednávek
    public int numberOfOrder(){
        return orders.size();
    }


//Počet položek
    public Map<String, Integer>itemsNumOfPieces(){
        HashMap<String, Integer> result = new HashMap<>();
        for (Order i : orders){
            for (Item item: i.items){
                String key = item.getTitle();
                int currentValue = 0;
                if (result.containsKey(key)){
                    currentValue = result.get(key);

                }
                result.put(key, currentValue+item.getQuantity());
            }
        }
            return result;
    }
//Celkový obrat za den
    public HashMap<LocalDate, BigDecimal>turnoverTotalPerDay(){
        HashMap<LocalDate, BigDecimal> result = new HashMap<>();
        for (Order i: orders){
            LocalDate orderDate = i.getDate();
            BigDecimal previousSum = BigDecimal.ZERO;
            if (result.containsKey(orderDate)){
                previousSum =result.get(orderDate);

            }  result.put(orderDate, previousSum.add(i.totalPrice()));
        }
        return result;
    }

//položky prodávané abecedně ()
    public SortedSet<String> itemsSoldAlphabetically() {
        TreeSet<String> items =new TreeSet<>();
        for (Order o : orders){
            for (Item i: o.getItems()){
                String title = i.getTitle();
                items.add(title);
            }
        } return items;
    }


// Objednávky na stůl
    public int[] ordersPerTable() {
        int[] result = new int[Settings.numberOfTables()];
        orders.forEach( o -> result[o.getNumberOfTables()]++);
        return result;
}



}
