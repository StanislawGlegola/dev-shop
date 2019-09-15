package com.devshop.devshop.repository;

import com.devshop.devshop.model.OrderItem;
import com.devshop.devshop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders, Long> {

	@Query(value = "SELECT * from orders WHERE status=false AND user_username = :username  ",nativeQuery = true)
	Orders FindOrderByUsername(String username);
}
