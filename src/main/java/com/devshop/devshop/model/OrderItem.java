package com.devshop.devshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(generator = "orderitemSeq")
	@SequenceGenerator(name = "orderitemSeq", sequenceName = "orderitem_seq", allocationSize = 1)
	private long id;
	private int amount;

	@ManyToOne(targetEntity = Order.class)
	private Order orderId;


	@ManyToOne(targetEntity = Product.class)
	private Product productId;

	public OrderItem(int amount) {
		this.amount = amount;
	}


	// na wszelki wypadek konstruktor dla wsyzstkich zmiennych
	public OrderItem(int amount, Order orderId, Product productId) {
		this.amount = amount;
		this.orderId = orderId;
		this.productId = productId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Order getOrderId() {
		return orderId;
	}

	public void setOrderId(Order orderId) {
		this.orderId = orderId;
	}

	public Product getProductId() {
		return productId;
	}

	public void setProductId(Product productId) {

		this.productId = productId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		OrderItem orderItem = (OrderItem) o;
		return id == orderItem.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
