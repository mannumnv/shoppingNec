package com.nec.shoppingnec.service.impl;

import com.nec.shoppingnec.dto.ProductDto;
import com.nec.shoppingnec.dto.ProductModelDto;
import com.nec.shoppingnec.model.Product;
import com.nec.shoppingnec.model.ProductModel;
import com.nec.shoppingnec.repository.ProductModelRepository;
import com.nec.shoppingnec.repository.ProductRepository;
import com.nec.shoppingnec.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductModelRepository modelRepository;

    public ProductServiceImpl(ProductRepository productRepository, ProductModelRepository modelRepository) {
        this.productRepository = productRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public ProductDto createProduct(ProductDto dto) {
        Product product = new Product(dto.getName(), dto.getCategory(), dto.getDescription());
        Product saved = productRepository.save(product);
        return toDto(saved);
    }

    @Override
    public ProductDto getProduct(Long id) {
        return productRepository.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public List<ProductDto> listProducts() {
        return productRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public ProductModelDto addModelToProduct(Long productId, ProductModelDto modelDto) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new IllegalArgumentException("Product not found"));
        ProductModel model = new ProductModel(modelDto.getModelName(), modelDto.getPrice(), modelDto.getStock());
        product.addModel(model);
        productRepository.save(product); // cascades
        return toModelDto(model);
    }

    @Override
    public List<ProductModelDto> listModelsByProduct(Long productId) {
        return modelRepository.findByProductId(productId).stream().map(this::toModelDto).collect(Collectors.toList());
    }

    private ProductDto toDto(Product p) {
        ProductDto dto = new ProductDto();
        dto.setId(p.getId());
        dto.setName(p.getName());
        dto.setCategory(p.getCategory());
        dto.setDescription(p.getDescription());
        dto.setModels(p.getModels().stream().map(this::toModelDto).collect(Collectors.toList()));
        return dto;
    }

    private ProductModelDto toModelDto(ProductModel m) {
        ProductModelDto dto = new ProductModelDto();
        dto.setId(m.getId());
        dto.setModelName(m.getModelName());
        dto.setPrice(m.getPrice());
        dto.setStock(m.getStock());
        return dto;
    }
}
