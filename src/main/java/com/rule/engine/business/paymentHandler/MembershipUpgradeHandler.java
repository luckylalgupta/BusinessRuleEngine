package com.rule.engine.business.paymentHandler;

import com.rule.engine.business.domain.*;
import com.rule.engine.business.repositories.MembershipRepository;
import com.rule.engine.business.services.NotificationService;

public class MembershipUpgradeHandler implements PaymentHandler {
    private final MembershipRepository _repo;
    private final NotificationService _notificationService;

    public MembershipUpgradeHandler(MembershipRepository _repo, NotificationService _notificationService) {
        this._repo = _repo;
        this._notificationService = _notificationService;
    }

    @Override
    public void run(Payment payment) {
        Order order = payment.get_order();
        Customer customer = order.get_customer();
        LineItem[] lineItems = order.get_lineItems();
        for(LineItem lineItem:lineItems){
            if(!lineItem.hasCategory(ProductCategory.Membership))
                continue;
            Membership membership = _repo.findBySku(lineItem.get_sku());
            Membership previousLevel = membership.get_previous();
            if(customer.hasMembership(previousLevel))
                customer.addMembership(membership,_notificationService);
        }
    }
}
