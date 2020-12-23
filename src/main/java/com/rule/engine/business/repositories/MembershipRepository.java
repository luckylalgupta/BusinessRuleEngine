package com.rule.engine.business.repositories;

import com.rule.engine.business.domain.Membership;

public interface MembershipRepository {
    Membership findBySku(String sku);
}
