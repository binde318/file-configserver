package com.binde.product.service;

import com.binde.product.dto.ProductRequest;
import com.binde.product.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    ProductResponse createProduct(ProductRequest request);

    Optional<ProductResponse> updateProduct(ProductRequest request, Long id);

    List<ProductResponse> fetchAllProducts();

    boolean deleteProduct(Long id);

    List<ProductResponse> searchProduct(String keyword);
}
