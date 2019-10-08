package com.devshop.devshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class OrderItem {

	@Id
	@GeneratedValue(generator = "orderitemSeq")
	@SequenceGenerator(name = "orderitemSeq", sequenceName = "orderitem_seq", allocationSize = 1)
	private int id;
	private int amount;

	@ManyToOne(targetEntity = Orders.class)
	private Orders orders;


	@ManyToOne(targetEntity = Product.class)
	private Product product;

	public OrderItem(int amount) {
		this.amount = amount;
	}

	public OrderItem() {
	}

	// na wszelki wypadek konstruktor dla wsyzstkich zmiennych
	public OrderItem(int amount, Orders orders, Product product) {
		this.amount = amount;
		this.orders = orders;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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
