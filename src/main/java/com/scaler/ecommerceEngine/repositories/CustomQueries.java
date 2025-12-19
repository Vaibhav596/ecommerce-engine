package com.scaler.ecommerceEngine.repositories;

import org.springframework.data.jpa.repository.Query;

public interface CustomQueries {
    String GET_PRODUCT_WITH_SUBCATEGORY_NAME = "select * from products p join categories c on p.category_id = c.id join subcategory s where s.category_id = c.id";
}
