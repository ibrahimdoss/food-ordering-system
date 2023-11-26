package com.food.ordering.system.order.service.dataaccess.order.repository;

import com.food.ordering.system.order.service.dataaccess.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository // bu annotation ile bu class'ın bir repository olduğunu spring'e belirtiyoruz. Spring bu class'ı tarayıp içerisindeki methodları buluyor ve bu methodları kullanarak sql sorguları oluşturuyor.
public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID>{

    Optional<OrderEntity> findByTrackingId(UUID trackingId);
}
