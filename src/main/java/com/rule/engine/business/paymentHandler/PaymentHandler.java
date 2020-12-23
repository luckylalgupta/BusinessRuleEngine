package com.rule.engine.business.paymentHandler;

import com.rule.engine.business.domain.Payment;

public interface PaymentHandler {
    void run (final Payment payment);
}
