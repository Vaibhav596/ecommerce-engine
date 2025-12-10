package com.scaler.ecommerceEngine.services;

import com.scaler.ecommerceEngine.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    public List<Product> getAllProducts(){
        return List.of();
    }
    public Product partialUpdateProduct(Long productId, Product product){
        return null;
    }
}
