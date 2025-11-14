package com.nec.shoppingnec.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "products") // It is connected to a database table called products.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;
    private String description;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProductModel> models = new ArrayList<>();

    public Product() {}

    public Product(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }

    // getters and setters

    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setCategory(String category) { this.category = category; }

    public void setDescription(String description) { this.description = description; }

    public void setModels(List<com.nec.shoppingnec.model.ProductModel> models) { this.models = models; }

    public void addModel(com.nec.shoppingnec.model.ProductModel model) {
        models.add(model);
        model.setProduct(this);
    }

    public void removeModel(com.nec.shoppingnec.model.ProductModel model) {
        models.remove(model);
        model.setProduct(null);
    }
}
