package com.nec.shoppingnec.dto;

import java.util.ArrayList;
import java.util.List;

public class ProductDto {
    private Long id;
    private String name;
    private String category;
    private String description;
    private List<com.nec.shoppingnec.dto.ProductModelDto> models = new ArrayList<>();

    public ProductDto() {}

    // getters and setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<com.nec.shoppingnec.dto.ProductModelDto> getModels() { return models; }
    public void setModels(List<com.nec.shoppingnec.dto.ProductModelDto> models) { this.models = models; }
}
