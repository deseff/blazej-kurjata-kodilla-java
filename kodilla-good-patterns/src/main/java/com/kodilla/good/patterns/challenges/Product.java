package com.kodilla.good.patterns.challenges;

public class Product {
    private String productName;
    private Double price;

    public Product(String productName, Double price) {
        this.productName = productName;
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public Double getPrice() {
        return price;
    }
}
