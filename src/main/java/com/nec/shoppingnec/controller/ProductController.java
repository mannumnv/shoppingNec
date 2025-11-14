package com.nec.shoppingnec.controller;

import com.nec.shoppingnec.dto.ProductDto;
import com.nec.shoppingnec.dto.ProductModelDto;
import com.nec.shoppingnec.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService svc;

    public ProductController(ProductService svc) {
        this.svc = svc;
    }

    @PostMapping
    public ResponseEntity<ProductDto> create(@RequestBody ProductDto dto) {
        ProductDto created = svc.createProduct(dto);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> list() {
        return ResponseEntity.ok(svc.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> get(@PathVariable Long id) {
        ProductDto dto = svc.getProduct(id);
        return dto != null ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping("/{id}/models")
    public ResponseEntity<ProductModelDto> addModel(@PathVariable Long id, @RequestBody ProductModelDto modelDto) {
        try {
            ProductModelDto created = svc.addModelToProduct(id, modelDto);
            return ResponseEntity.ok(created);
        } catch (IllegalArgumentException ex) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}/models")
    public ResponseEntity<List<ProductModelDto>> listModels(@PathVariable Long id) {
        return ResponseEntity.ok(svc.listModelsByProduct(id));
    }
}
