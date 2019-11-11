package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    public static void main(String[] args) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        OrderProcessor orderProcessor = new OrderProcessor(
                new EmailService(), new CDOrderService(), new CDOrderRepository());
        orderProcessor.process(orderRequest);
    }
}
