package com.kodilla.good.patterns.food2Door;

import java.util.ArrayList;
import java.util.Optional;

public class ExtraFoodShop implements Supplier {
    private ArrayList<Product> productsList;

    public ExtraFoodShop() {

        productsList = new ArrayList<>();

        productsList.add(new Product("Shrimps", 40));
        productsList.add(new Product("Caviar", 100));
        productsList.add(new Product("Saffron", 30));
        productsList.add(new Product("Clams", 50));
    }

    @Override
    public boolean process(OrderRequest orderRequest) throws ProductNotFoundException {
        Optional<Product> productOptional = productsList.stream()
                .filter(productInList -> productInList.getProductName().equals(orderRequest.getProduct().getProductName()))
                .findAny();

        if (productOptional.isPresent()) {
            System.out.println("Order in ExtraFoodShop has been placed.");
            return true;
        }
        throw new ProductNotFoundException("Product " + orderRequest.getProduct().getProductName() + " was not found.");
    }
}