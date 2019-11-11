package com.kodilla.good.patterns.food2Door;

public class OrderProcessor {
    private OrderService orderService;

    public OrderProcessor(OrderService orderService) {
        this.orderService = orderService;
    }

    OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
    OrderRequest orderRequest = orderRequestRetriever.retrieve();

    void processOrder(OrderDto orderDto) {

        switch (orderDto.getShopTypeEnum()) {
            case EXTRA_FOOD_SHOP:
                ExtraFoodShop extraFoodShop = new ExtraFoodShop();
                extraFoodShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopTypeEnum());
                break;

            case GLUTEN_FREE_SHOP:
                GlutenFreeShop glutenFreeShop = new GlutenFreeShop();
                glutenFreeShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopTypeEnum());
                break;

            case HEALTHY_SHOP:
                HealthyShop healthyShop = new HealthyShop();
                healthyShop.process(orderRequest);
                orderService.order(orderRequest.getProduct(), orderRequest.getQuantity(), orderDto.getShopTypeEnum());
                break;

            default:
                throw new ShopNotFoundException("Shop not found");
        }

    }
}
