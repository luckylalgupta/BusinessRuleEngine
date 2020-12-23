package com.rule.engine.business.paymentHandler;

import com.rule.engine.business.domain.LineItem;
import com.rule.engine.business.domain.Order;
import com.rule.engine.business.domain.Payment;
import com.rule.engine.business.domain.ProductCategory;
import com.rule.engine.business.services.PackingSlipService;
import com.rule.engine.business.services.RoyaltyService;
import com.rule.engine.business.services.ShippingService;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class PaymentSlipHandler implements PaymentHandler {

    private final PackingSlipService _packingSlipService;
    private  final ShippingService _shippingService;
    private final RoyaltyService _royaltyService;

    public PaymentSlipHandler(PackingSlipService _packingSlipService, ShippingService _shippingService, RoyaltyService _royaltyService) {
        this._packingSlipService = _packingSlipService;
        this._shippingService = _shippingService;
        this._royaltyService = _royaltyService;
    }

    @Override
    public void run(Payment payment) {
        final Order order = payment.get_order();
        final LineItem[] lineItems = order.get_lineItems();

        Boolean generateForShipping = false;
        Boolean generateForRoyalty = false;

        for(final LineItem lineItem:lineItems){
            if(lineItem.hasCategory(ProductCategory.Physical))
                generateForShipping = true;
            if(lineItem.hasCategory(ProductCategory.Books))
                generateForRoyalty = true;
            if(lineItem.get_sku()=="learning-to-ski")
                order.addGiftBySku("first-aid");
        }
        _packingSlipService.generate(order);
        if(generateForShipping)
            _shippingService.generatePackingSlip(order);
        if(generateForRoyalty)
            _royaltyService.generatePackingSlip(order);


    }
}
