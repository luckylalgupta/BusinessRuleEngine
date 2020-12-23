package com.rule.engine.business.domain;

public class Product {
    private  String sku;

    public Product(String sku) {
        this.sku = sku;
    }

    public String getSku() {
        return sku;
    }
}
