package com.food.ordering.system.order.service.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean // Bu annotation ile bu sınıfın bir bean olduğunu belirtiyoruz. Bu sayede bu sınıfı başka sınıflarda kullanabiliriz.
    //@Bean temelde yaptığı şey, bu sınıfın bir nesnesini oluşturup, bu nesneyi Spring Context'e eklemektir.
    // Bu nesneyi Spring Context'e eklediğimiz için de bu nesneyi başka sınıflarda kullanabiliriz.
    public OrderDomainService orderDomainService() {
        return new OrderDomainServiceImpl();
    }
}
