package com.devshop.devshop.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "productSeq")
    //to informuje ze jest sekwencja o takiej nazwie która identyfikje identyfikatory. jej nazwa w bazie danych powinna byc product_seq).
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    private int id;

    private String productName;
    private String description;
    private BigDecimal price;
    private int amount;

    @ManyToOne(targetEntity = Category.class)
    private Category categoryId;

    public Product(String productName, String description, BigDecimal price, int amount) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amount = amount;
    }

    public Product(String productName, String description, BigDecimal price, int amount, Category categoryId) {
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
