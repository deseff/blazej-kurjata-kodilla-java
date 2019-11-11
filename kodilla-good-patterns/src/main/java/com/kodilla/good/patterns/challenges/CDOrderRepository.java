package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class CDOrderRepository implements OrderRepository {

    @Override
    public boolean createOrder(User user, LocalDateTime orderDate) {
        System.out.println("Order for user " + user.getNickName() + " " + user.getFirstName()  + " " + user.getLastName() +
                " has been created on" + " " + orderDate);
        return true;
    }
}
