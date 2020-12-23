package com.rule.engine.business.services;

import com.rule.engine.business.domain.Order;
import com.rule.engine.business.domain.PackingSlip;

public interface ShippingService {
    PackingSlip generatePackingSlip(Order order);
}
