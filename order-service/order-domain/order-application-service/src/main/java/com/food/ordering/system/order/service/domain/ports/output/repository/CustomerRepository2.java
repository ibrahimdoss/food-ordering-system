package com.food.ordering.system.order.service.domain.ports.output.repository;

import com.food.ordering.system.order.service.domain.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public interface CustomerRepository2 {

   Optional<Customer> findCustomer(UUID customerId);

   Customer save(Customer customer);
}
