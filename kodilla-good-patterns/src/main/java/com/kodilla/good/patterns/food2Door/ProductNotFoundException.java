package com.kodilla.good.patterns.food2Door;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
