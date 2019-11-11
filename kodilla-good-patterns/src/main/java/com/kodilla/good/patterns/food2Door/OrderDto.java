package com.kodilla.good.patterns.food2Door;

public class OrderDto {
    private ShopTypeEnum shopTypeEnum;

    public OrderDto(ShopTypeEnum shopTypeEnum) {
        this.shopTypeEnum = shopTypeEnum;
    }

    public ShopTypeEnum getShopTypeEnum() {
        return shopTypeEnum;
    }
}
