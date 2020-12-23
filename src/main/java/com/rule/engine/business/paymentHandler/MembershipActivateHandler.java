package com.rule.engine.business.paymentHandler;

import com.rule.engine.business.domain.*;
import com.rule.engine.business.repositories.MembershipRepository;
import com.rule.engine.business.services.NotificationService;

public class MembershipActivateHandler implements PaymentHandler{
    private final MembershipRepository _service;
    private final NotificationService _notificationService;

    public MembershipActivateHandler(MembershipRepository _service, NotificationService _notificationService) {
        this._service = _service;
        this._notificationService = _notificationService;
    }

    @Override
    public void run(Payment payment) {
        final Order order =payment.get_order();
        final LineItem[] lineItems = order.get_lineItems();
        final Customer customer = order.get_customer();

        for(final LineItem lineItem:lineItems){
            if(!lineItem.hasCategory(ProductCategory.Membership))
                continue;
            final Membership membership = _service.findBySku(lineItem.get_sku());
            if(membership!=null)
                customer.addMembership(membership,_notificationService);
        }
    }
}
