package com.devshop.devshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Order {

	@Id
	@GeneratedValue(generator = "orderSeq")
	@SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
	private long id;

	@ManyToOne(targetEntity = User.class)
	private User userId;

	public Order() {
	}

	public Order(User userId) {
		this.userId = userId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public void setUser(User user) {
		this.userId = user;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return id == order.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
