package com.devshop.devshop.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Orders {

	@Id
	@GeneratedValue(generator = "orderSeq")
	@SequenceGenerator(name = "orderSeq", sequenceName = "order_seq", allocationSize = 1)
	private long id;

	@ManyToOne(targetEntity = User.class)
	private User user;

	private boolean status;


	public Orders() {
	}

	public Orders(User user) {
		this.user = user;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
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
		Orders orders = (Orders) o;
		return id == orders.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
