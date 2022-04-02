package com.company;

import java.math.BigDecimal;
import java.time.LocalDate;

public class PurchaseNakup {
    private String description;
    private Category category;
    private BigDecimal price;
    private LocalDate purchaseDate;

    public PurchaseNakup(String description, Category category, BigDecimal price, LocalDate purchaseDate) {
        this.description = description;
        this.category = Category.OTHERS;
        this.price = price;
        this.purchaseDate = purchaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    @Override
    public String toString() {
        return "PurchaseNakup{" +
                "description='" + description + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", purchaseDate=" + purchaseDate +
                '}';
    }
}
