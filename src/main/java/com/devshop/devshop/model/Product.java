package com.devshop.devshop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Product {

    @Id
    @GeneratedValue(generator = "productSeq")
    //to informuje ze jest sekwencja o takiej nazwie która identyfikje identyfikatory. jej nazwa w bazie danych powinna byc product_seq).
    @SequenceGenerator(name = "productSeq", sequenceName = "product_seq", allocationSize = 1)
    private int id;

    private String productName;
    private String discription;
    private double price;
    private long amount;

    public Product() {
        this.productName = productName;
        this.discription = discription;
        this.price = price;
        this.amount = amount;
    }

    public Product(String productName, String productDiscription, Long price, long amount) {
        this.productName = productName;
        this.discription = productDiscription;
        this.price = price;
        this.amount = amount;
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

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
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
