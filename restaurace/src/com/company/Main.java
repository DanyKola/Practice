package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.SortedSet;

public class Main {
    private static TolalOrder tolalOrder = new TolalOrder();




    public static void priperData() {
    try {



        Order order;
        order = new Order(1, LocalDate.of(2021, 05, 20), Payment.CASH);
        order.addItem(new Item("Caesar salát", BigDecimal.valueOf(150), 2));
        order.addItem(new Item("Big Burger", BigDecimal.valueOf(350), 1));
        order.addItem(new Item(" Mattoni", BigDecimal.valueOf(30), 3));
        tolalOrder.addOrder(order);

        order = new Order(5, LocalDate.of(2021, 05, 18), Payment.CARD);
        order.addItem(new Item("Big Burger", BigDecimal.valueOf(350), 2));
        order.addItem(new Item("Kofola velká", BigDecimal.valueOf(30), 2));
        tolalOrder.addOrder(order);

        order = new Order(1, LocalDate.of(2021, 05, 20), Payment.CARD);
        order.addItem(new Item("Svíčková na smetaně", BigDecimal.valueOf(220), 1));
        order.addItem(new Item("Big Burger", BigDecimal.valueOf(350), 1));
        order.addItem(new Item("Smažený hermelín", BigDecimal.valueOf(135), 1));
        order.addItem(new Item("Palačinky s jahodami", BigDecimal.valueOf(160), 1));
        order.addItem(new Item("Mattoni", BigDecimal.valueOf(30), 2));
        order.addItem(new Item(" Malinovka domácí", BigDecimal.valueOf(45), 3));
        tolalOrder.addOrder(order);

        order = new Order(2, LocalDate.of(2021, 05, 18), Payment.CARD);
        order.addItem(new Item("Smažený hermelín", BigDecimal.valueOf(135), 3));
        order.addItem(new Item(" Malinovka domácí", BigDecimal.valueOf(45), 3));
        tolalOrder.addOrder(order);

        order = new Order(6, LocalDate.of(2021, 05, 21), Payment.CARD);
        order.addItem(new Item("Big Burger", BigDecimal.valueOf(350), 1));
        order.addItem(new Item("Kofola velká", BigDecimal.valueOf(30), 1));
        tolalOrder.addOrder(order);

    } catch (Exception e){
        e.printStackTrace();
    }
    }

    public static void main(String[] args) {
       priperData();
        // 3. Na základě názvu položky spočítejte celkový počet kusů dané položky, které jsme prodali:
        System.out.println(tolalOrder.numberOfOrder());

        // 4. Spočítejte celkový obrat (turnover) ze všech objednávek za jednotlivé dny:
        System.out.println(tolalOrder.turnoverTotalPerDay());

        // 5. Připravte metodu, která získá výpis všech názvů položek,
        //  které byly objednány.
        //  Pokud byla položka objednána vícekrát, ve výpisu bude jen jednou.
        //  Položky ve výpisu budou seřazené podle abecedy.
        SortedSet<String> items = tolalOrder.itemsSoldAlphabetically();
        System.out.println(items);

        // 6. Vypište počet objednávek pro jednotlivé stoly.
        int[] ordersPerTable = tolalOrder.ordersPerTable();
        System.out.println("Počet objednávek u jednotlivých stolů:");
        for (int i = 0; i < ordersPerTable.length; i++) {
            int numberOfOrdersOnThisTable = ordersPerTable[i];
            if (numberOfOrdersOnThisTable > 0) {
                System.out.println("Stůl č. " + i + ": \t" + numberOfOrdersOnThisTable);
            }

    }}

}
