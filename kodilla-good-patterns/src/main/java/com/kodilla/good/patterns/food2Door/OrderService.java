package com.kodilla.good.patterns.food2Door;

public interface OrderService {
    boolean order(Product product, Double quantity, ShopTypeEnum shopTypeEnum);
}
