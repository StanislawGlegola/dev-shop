package com.devshop.devshop.repository;


import com.devshop.devshop.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

	@Query(value = "SELECT * from order_item WHERE orders_id = :orders",nativeQuery = true)
	List<OrderItem> findByOrders(Long orders);


}
