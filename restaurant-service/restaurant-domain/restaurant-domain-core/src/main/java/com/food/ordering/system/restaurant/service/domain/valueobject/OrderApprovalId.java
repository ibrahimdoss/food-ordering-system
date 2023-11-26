package com.food.ordering.system.restaurant.service.domain.valueobject;

import com.food.ordering.system.domain.valueobject.BaseID;

import java.util.UUID;

public class OrderApprovalId extends BaseID<UUID> {

    public OrderApprovalId(UUID value) {
        super(value);
    }
}
