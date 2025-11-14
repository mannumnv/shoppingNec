package com.nec.shoppingnec.repository;

import com.nec.shoppingnec.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductModelRepository extends JpaRepository<ProductModel, Long> {
    List<ProductModel> findByProductId(Long productId);
}
