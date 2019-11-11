package com.kodilla.good.patterns.food2Door;

public interface Supplier {
    boolean process(OrderRequest orderRequest) throws ProductNotFoundException;
}
