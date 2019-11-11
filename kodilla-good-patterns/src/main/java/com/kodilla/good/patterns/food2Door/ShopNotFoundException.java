package com.kodilla.good.patterns.food2Door;

public class ShopNotFoundException extends RuntimeException {
    public ShopNotFoundException(String errorMessage) {
        super(errorMessage);
    }

}
