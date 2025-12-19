package com.scaler.ecommerceEngine.repositories;

import com.scaler.ecommerceEngine.models.Category;
import com.scaler.ecommerceEngine.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

    Category save(Category category);
}
