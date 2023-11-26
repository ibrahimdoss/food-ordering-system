package com.food.ordering.system.payment.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseID;

import java.util.UUID;

public class CreditHistoryId extends BaseID<UUID> {
    public CreditHistoryId(UUID value) {
        super(value);
    }
}
