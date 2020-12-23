package com.rule.engine.business.services;

import com.rule.engine.business.domain.Order;
import com.rule.engine.business.domain.PackingSlip;

public interface RoyaltyService {
    PackingSlip generatePackingSlip(Order order);
}
