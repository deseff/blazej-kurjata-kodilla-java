package com.kodilla.good.patterns.food2Door;

public class HealthyShop implements Supplier {

    @Override
    public boolean process(OrderRequest orderRequest) {
        System.out.println("Order for " + orderRequest.getQuantity() + " piece(s) of " + orderRequest.getProduct().getProductName() +
                " has been placed in HealthyShop.");
        return true;
    }
}
