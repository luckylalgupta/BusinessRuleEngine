package com.rule.engine.business.domain;

public class Membership extends Product {
    public Membership(String sku , Membership prev){
        super(sku);
        _previous = prev;
    }
    private Membership _previous;

    public Membership get_previous() {
        return _previous;
    }
}
