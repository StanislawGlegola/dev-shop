package com.devshop.devshop.repository;

import com.devshop.devshop.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	@Query(value = "SELECT * from orders WHERE status=false AND user_username = :username  ",nativeQuery = true)
	Orders findOrderByUsername(String username);
}
