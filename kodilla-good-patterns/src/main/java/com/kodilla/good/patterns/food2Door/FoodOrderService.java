package com.kodilla.good.patterns.food2Door;

public class FoodOrderService implements OrderService {
    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieve();

    @Override
    public boolean order(Product product, Double quantity, ShopTypeEnum shopTypeEnum) {
        System.out.println("Order for " + orderRequest.getQuantity() + " piece(s) of " + product.getProductName() +
                " for amount " + orderRequest.getQuantity() * product.getProductPrice() + " PLN has been placed in " +
                orderRequest.getShopTypeEnum() + ".");
        return false;
    }
}
