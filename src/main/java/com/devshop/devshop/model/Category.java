package com.devshop.devshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Category {

	@Id
	@GeneratedValue(generator = "categorySeq")
	@SequenceGenerator(name = "categorySeq", sequenceName = "category_seq", allocationSize = 1)
	private long id;
	private String categoryName;

	public Category(String categoryName) {
		this.categoryName = categoryName;
	}

	public Category() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Category category = (Category) o;
		return id == category.id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
