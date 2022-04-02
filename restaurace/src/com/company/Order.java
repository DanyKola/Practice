package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static int nextId = 0;

    private int id = nextId++;
    private int numberOfTables;
    private LocalDate date;
    private Payment payment;
    ArrayList<Item> items = new ArrayList<>();

    public Order(int numberOfTables, LocalDate date, Payment payment) {
        this.numberOfTables = numberOfTables;
        this.date = date;
        this.payment = payment;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Order.nextId = nextId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberOfTables() {
        return numberOfTables;
    }

    public void setNumberOfTables(int numberOfTables) throws RestauravtException {
        int nOfTables = Settings.numberOfTables();
        if (numberOfTables>nOfTables) throw new RestauravtException("Zadané číslo stolu: "+numberOfTables+" je vyšší než počet stolů v restauraci: "+nOfTables);
        this.numberOfTables = numberOfTables;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public ArrayList<Item> getItems() {
        return (ArrayList<Item>) items.clone();
    }

//Přidání položky
    public void addItem(Item item){
        this.items.add(item);
    }
//Suma cen položek
    public BigDecimal totalPrice(){
    BigDecimal result = BigDecimal.ZERO;
    for (Item i:items){
        result =result.add(i.getPrice().multiply(BigDecimal.valueOf(i.getQuantity())));

    }   return result;
    }
}