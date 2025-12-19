package com.scaler.ecommerceEngine.repositories;

import com.scaler.ecommerceEngine.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Update is also done using save()
    // If the product you try to save has an ID:
    // JPA will see if a product with that ID exists:
    // If no -> Insert
    // If yes -> Update
    @Override
    Product save(Product p);

    @Override
    void delete(Product entity);

    List<Product> findAll();

    Optional<Product> findById(Long id);

    List<Product> findAllByCategory_Subcategory_SurnameEquals(String subcategorySurname);

    @Query("select p " +
            "FROM Product p " +
            "where p.category.subcategory.surname = :categorySurname")
    List<Product> sqlQuery1(@Param("categorySurname") String categorySurname);

    @Query("select p " +
            "from Product p " +
            "where p.id > :idGreaterThan")
    List<Product> sqlQuery2(@Param("idGreaterThan") Long idGreaterThan);

    @Query(value = CustomQueries.GET_PRODUCT_WITH_SUBCATEGORY_NAME,
                            nativeQuery = true
    )
    List<Product> customQueryFunc();
}
