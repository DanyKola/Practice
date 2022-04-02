package com.company;

import java.math.BigDecimal;

public class Item {

        private String title;
        private BigDecimal price;
        private int quantity;

        public Item(String title, BigDecimal price, int quantity) {
                this.title = title;
                this.price = price;
                this.quantity = quantity;
        }

        public String getTitle() {
                return title;
        }

        public BigDecimal getPrice() {
                return price;
        }

        public int getQuantity() {
                return quantity;
        }



        @Override
        public String toString() {
                return title + " - " + price +" Kč - "+ quantity+" ks";
        }
}
