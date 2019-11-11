package com.kodilla.good.patterns.food2Door;

public class OrderRequest {
    private Product product;
    private double quantity;
    ShopTypeEnum shopTypeEnum;

    public OrderRequest(Product product, double quantity, ShopTypeEnum shopTypeEnum) {
        this.product = product;
        this.quantity = quantity;
        this.shopTypeEnum = shopTypeEnum;
    }

    public Product getProduct() {
        return product;
    }

    public double getQuantity() {
        return quantity;
    }

    public ShopTypeEnum getShopTypeEnum() {
        return shopTypeEnum;
    }
}
