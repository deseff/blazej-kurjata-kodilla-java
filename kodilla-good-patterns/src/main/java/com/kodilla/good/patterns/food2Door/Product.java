package com.kodilla.good.patterns.food2Door;

public class Product {
    private String productName;
    private double productPrice;

    public Product(String productName, double productPrice) {
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (Double.compare(product.productPrice, productPrice) != 0) return false;
        return productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productName.hashCode();
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
