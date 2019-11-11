package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;

public class OrderRequest {
    private User user;
    private LocalDateTime orderDate;
    private Product product;
    private Double quantity;

    public OrderRequest(User user, LocalDateTime orderDate, Product product, Double quantity) {
        this.user = user;
        this.orderDate = orderDate;
        this.product = product;
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public Product getProduct() {
        return product;
    }

    public Double getQuantity() {
        return quantity;
    }
}
