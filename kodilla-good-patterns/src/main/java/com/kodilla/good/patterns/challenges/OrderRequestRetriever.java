package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequestRetriever {
    public OrderRequest retrieve() {
        User user = new User("John", "Malkovich", "Being");
        LocalDateTime dateOfOrder = LocalDateTime.of(2019, 10, 26, 20, 30);
        Product product = new Product("Metallica, Reload", 40.0);
        Double quantity = 1.0;

        return new OrderRequest(user, dateOfOrder, product, quantity);
    }
}
