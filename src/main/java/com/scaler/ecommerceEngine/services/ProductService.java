package com.scaler.ecommerceEngine.services;

import com.scaler.ecommerceEngine.models.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);
    List<Product> getAllProducts();
    Product partialUpdateProduct(Long productId, Product product);
}
