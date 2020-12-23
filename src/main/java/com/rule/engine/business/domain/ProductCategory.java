package com.rule.engine.business.domain;

public class ProductCategory {
    public final String _name;

    public String get_name() {
        return _name;
    }

    public ProductCategory(String _name) {
        this._name = _name;
    }
    public static final ProductCategory Books = new ProductCategory("books");
    public static final ProductCategory Physical = new ProductCategory("physical");
    public static final ProductCategory Virtual = new ProductCategory("virtual");
    public static final ProductCategory Membership = new ProductCategory("membership");
    public static final ProductCategory Videos = new ProductCategory("videos");
}
