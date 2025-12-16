package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.models.Category;
import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDto {
    private String title;
    private String description;
    private double price;
    private String imageUrl;
    private String categoryName;

    public Product toProduct() {
        Product product = new Product();
        product.setTitle(this.title);
        product.setDescription(this.description);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
        Category category = new Category();
        category.setName(this.categoryName);
        product.setCategory(category);

        return product;
    }
}
