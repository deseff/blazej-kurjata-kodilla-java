package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CDOrderService implements OrderService {

    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieve();

    @Override
    public boolean order(User user, LocalDateTime orderDate, Product product, Double quantity) {
        System.out.println("User " + user.getNickName() + " " + user.getFirstName() + " " + user.getLastName() +
                " created order for " + orderRequest.getQuantity() + " piece(s) of "  + orderRequest.getProduct().getProductName() +
                " on " + orderRequest.getOrderDate() +"." + "\n" + "Total amount to be paid equals " +
                orderRequest.getQuantity() * orderRequest.getProduct().getPrice() + " PLN.");
        return true;
    }
}
