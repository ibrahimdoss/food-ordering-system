package com.food.ordering.system.order.service.domain.event;

import com.food.ordering.system.domain.event.DomainEvent;
import com.food.ordering.system.order.service.domain.entity.Order;

import java.time.ZonedDateTime;

public abstract class OrderEvent implements DomainEvent<Order>{

    private final Order order;
    private final ZonedDateTime createdDate;

    public OrderEvent(Order order, ZonedDateTime createdDate) {
        this.order = order;
        this.createdDate = createdDate;
    }


    public Order getOrder() {
        return order;
    }

    public ZonedDateTime getCreatedDate() {
        return createdDate;
    }



}
