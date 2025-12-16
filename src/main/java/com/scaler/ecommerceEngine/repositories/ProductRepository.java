package com.scaler.ecommerceEngine.repositories;

import com.scaler.ecommerceEngine.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {


}
