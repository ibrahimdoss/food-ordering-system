package com.food.ordering.system.order.service.domain.entity;

import com.food.ordering.system.domain.entity.AggregateRoot;
import com.food.ordering.system.domain.valueobject.CustomerId;
import lombok.Getter;

@Getter
public class Customer extends AggregateRoot<CustomerId> {
    private String username;
    private String firstName;
    private String lastName;
    public Customer() {

    }

    public Customer(CustomerId customerId, String username, String lastName, String firstName) {
        super.setId(customerId);
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Customer(CustomerId customerId) {
        super.setId(customerId);
    }

}
