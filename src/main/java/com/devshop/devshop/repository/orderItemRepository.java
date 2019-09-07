package com.devshop.devshop.repository;


import com.devshop.devshop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderItemRepository extends JpaRepository<OrderItem, Long> {
}
