package com.devshop.devshop.repository;

import com.devshop.devshop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order, Long> {
}
