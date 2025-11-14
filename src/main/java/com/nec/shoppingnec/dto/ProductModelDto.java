package com.nec.shoppingnec.dto;

import java.math.BigDecimal;

public class ProductModelDto {
    private Long id;
    private String modelName;
    private BigDecimal price;
    private Integer stock;

    public ProductModelDto() {}

    public ProductModelDto(Long id, String modelName, BigDecimal price, Integer stock) {
        this.id = id;
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
}
