package com.nec.shoppingnec.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "product_models") // This class is saved in the database table product_models.
// This class represents each model/version of a product.
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String modelName;
    private BigDecimal price;
    private Integer stock;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    public ProductModel() {}

    public ProductModel(String modelName, BigDecimal price, Integer stock) {
        this.modelName = modelName;
        this.price = price;
        this.stock = stock;
    }

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getModelName() { return modelName; }
    public void setModelName(String modelName) { this.modelName = modelName; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public com.nec.shoppingnec.model.Product getProduct() { return product; }
    public void setProduct(com.nec.shoppingnec.model.Product product) { this.product = product; }
}
