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
    private String productDiscription;
    private Long price;
    private boolean status;

    public Product() {
        this.id = 1;
        this.productName = "Laptop Acer";
        this.productDiscription="Cool laptop.";
        this.price=3200L;
        this.status=true;
    }

    public Product(String productName, String productDiscription, Long price, boolean status) {
        this.productName = productName;
        this.productDiscription = productDiscription;
        this.price = price;
        this.status = status;
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

    public String getProductDiscription() {
        return productDiscription;
    }

    public void setProductDiscription(String productDiscription) {
        this.productDiscription = productDiscription;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productDiscription='" + productDiscription + '\'' +
                ", price=" + price +
                ", status=" + status +
                '}';
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
