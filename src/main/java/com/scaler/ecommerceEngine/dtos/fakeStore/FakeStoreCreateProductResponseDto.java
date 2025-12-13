package com.scaler.ecommerceEngine.dtos.fakeStore;

import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreCreateProductResponseDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;

    public Product toProduct() {
        Product product1 = new Product();
        product1.setId(this.getId());
        product1.setTitle(this.getTitle());
        product1.setDescription(this.getDescription());
        product1.setImageUrl(this.getImage());
        product1.setCategoryName(this.getCategory());
        product1.setPrice(this.getPrice());
        return product1;
    }
}
