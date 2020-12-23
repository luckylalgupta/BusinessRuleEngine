package com.rule.engine.business.services;

import com.rule.engine.business.domain.Customer;
import com.rule.engine.business.domain.Membership;

public interface NotificationService {
    void notify(Customer customer , Membership membership);
}
