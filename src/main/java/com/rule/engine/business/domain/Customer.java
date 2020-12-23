package com.rule.engine.business.domain;

public class Customer {
    public void addMembership(Membership membership , NotificationService notificationService){
        notificationService.notify(this,membership);
    }
    public boolean hasMembership(Membership membership){
        return false;
    }
}
