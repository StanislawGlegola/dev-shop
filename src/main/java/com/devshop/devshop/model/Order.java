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
	private User user;

	public Order() {
	}

	public Order(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
