package com.rule.engine.business.domain;

import com.rule.engine.business.services.NotificationService;

public class Customer {
    public void addMembership(Membership membership , NotificationService notificationService){
        notificationService.notify(this,membership);
    }
    public boolean hasMembership(Membership membership){
        return false;
    }
}
