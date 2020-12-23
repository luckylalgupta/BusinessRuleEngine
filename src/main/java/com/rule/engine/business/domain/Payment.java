package com.rule.engine.business.domain;



public class Payment {
    private final Order _order;
    public Payment(final Order order){
        this._order = order;
    }

    public Order get_order() {
        return _order;
    }
    public void Process(PaymentHandler[] rules){
        for(PaymentHandler rule :rules){
            rule.run(this);
        }
    }
}
