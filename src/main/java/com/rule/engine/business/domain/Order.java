package com.rule.engine.business.domain;

import java.util.HashSet;

public class Order {
    private final Customer _customer;
    private final LineItem[] _lineItems;
    private final Agent _agent;
    private HashSet<String> _giftSkus;

    public Order(final Customer customer,final LineItem[] lineItems,final Agent agent) throws IllegalArgumentException {
        if(lineItems == null || lineItems.length==0){
            throw new IllegalArgumentException("line Items are required");
        }
        this._customer = customer;
        this._lineItems = lineItems;
        this._agent = agent;
        this._giftSkus = new HashSet<String>();
    }

    public Customer get_customer() {
        return _customer;
    }

    public LineItem[] get_lineItems() {
        return _lineItems;
    }

    public Agent get_agent() {
        return _agent;
    }
    public void addGiftBySku(String sku){
        if(!this._giftSkus.contains(sku)){
            this._giftSkus.add(sku);
        }
    }
    public String[] getGiftSkus(){
        return this._giftSkus.toArray(new String[0]);
    }
}
