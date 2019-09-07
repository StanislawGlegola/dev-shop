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
	private Order order;


	@ManyToOne(targetEntity = Product.class)
	private Product product;

	public OrderItem(int amount) {
		this.amount = amount;
	}


	// na wszelki wypadek konstruktor dla wsyzstkich zmiennych
	public OrderItem(int amount, Order order, Product product) {
		this.amount = amount;
		this.order = order;
		this.product = product;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {

		this.product = product;
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
