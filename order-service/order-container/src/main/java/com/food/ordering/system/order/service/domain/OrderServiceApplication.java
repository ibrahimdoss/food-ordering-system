package com.food.ordering.system.order.service.domain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.food.ordering.system.order.service.dataaccess","com.food.ordering.system.dataaccess"})//Repositorylerin bulunduğu paketin adını belirtir.
@EntityScan(basePackages = {"com.food.ordering.system.order.service.dataaccess","com.food.ordering.system.dataaccess"})//Entitylerin bulunduğu paketin adını belirtir.
@SpringBootApplication(scanBasePackages = "com.food.ordering.system")//scanBasePackages burada yazılan paketlerin altındaki paketleri tarar ve bulur.
// Bu sayede her paket için ayrı ayrı yazmamıza gerek kalmaz.
public class OrderServiceApplication {

    public static void main (String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }
}
