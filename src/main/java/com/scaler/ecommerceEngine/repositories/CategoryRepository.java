package com.scaler.ecommerceEngine.repositories;

import com.scaler.ecommerceEngine.models.Category;
import com.scaler.ecommerceEngine.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    // Update is also done using save()
    // If the product you try to save has an ID:
    // JPA will see if a product with that ID exists:
    // If no -> Insert
    // If yes -> Update
    @Override
    Product save(Product p);

    @Override
    void delete(Product entity);
}
