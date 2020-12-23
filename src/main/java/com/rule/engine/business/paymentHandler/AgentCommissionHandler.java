package com.rule.engine.business.paymentHandler;

import com.rule.engine.business.domain.*;

public class AgentCommissionHandler implements PaymentHandler {
    @Override
    public void run(Payment payment) {
        Order order = payment.get_order();
        LineItem[] lineItems = order.get_lineItems();

        Boolean addCommission = false;

        for(LineItem lineItem : lineItems){
            if(lineItem.hasCategory(ProductCategory.Books)||
            lineItem.hasCategory(ProductCategory.Physical)){
                addCommission = true;
                break;
            }
        }
        if(addCommission){
            Agent agent = order.get_agent();
            agent.generateCommission(order);
        }
    }
}
