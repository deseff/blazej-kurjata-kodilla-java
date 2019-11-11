package com.kodilla.good.patterns.food2Door;

public class OrderRequestRetriever {
    private ShopTypeEnum shopTypeEnum;

    public OrderRequest retrieve() {
        Product product = new Product("Clams", 40);
        Double quantity = 2.0;
        shopTypeEnum = ShopTypeEnum.EXTRA_FOOD_SHOP;

        return new OrderRequest(product, quantity, shopTypeEnum);
    }
}
