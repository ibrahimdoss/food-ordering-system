package com.food.ordering.system.order.service.domain;

import com.food.ordering.system.order.service.domain.dto.message.CustomerModel;
import com.food.ordering.system.order.service.domain.entity.Customer;
import com.food.ordering.system.order.service.domain.exception.OrderDomainException;
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper;
import com.food.ordering.system.order.service.domain.ports.input.message.listener.customer.CustomerMessageListener;
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CustomerMessageListenerImpl implements CustomerMessageListener {

    private final CustomerRepository2 customerRepository2;

    private final OrderDataMapper orderDataMapper;


    public CustomerMessageListenerImpl(CustomerRepository2 customerRepository2, OrderDataMapper orderDataMapper) {
        this.customerRepository2 = customerRepository2;
        this.orderDataMapper = orderDataMapper;
    }


    @Override
    public void customerCreated(CustomerModel customerModel) {
        Customer customer = customerRepository2.save(orderDataMapper.customerModelToCustomer(customerModel));
        if (customer == null) {
            log.error("Customer could not be created in order database with id: {}", customerModel.getId());
            throw new OrderDomainException("Customer could not be created in order database with id " +
                    customerModel.getId());
        }
        log.info("Customer is created in order database with id: {}", customer.getId());

    }
}
