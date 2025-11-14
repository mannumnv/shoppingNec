package com.nec.shoppingnec.service;

import com.nec.shoppingnec.dto.ProductDto;
import com.nec.shoppingnec.dto.ProductModelDto;

import java.util.List;

public interface ProductService {
    ProductDto createProduct(ProductDto dto);
    ProductDto getProduct(Long id);
    List<ProductDto> listProducts();
    ProductModelDto addModelToProduct(Long productId, ProductModelDto modelDto);
    List<ProductModelDto> listModelsByProduct(Long productId);
}
