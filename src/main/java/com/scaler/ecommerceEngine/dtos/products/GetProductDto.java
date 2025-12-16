package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductDto {
    private Long id;
    private String title;
    private double price;
    private String imageUrl;
    private String description;
    private String categoryName;

    public static GetProductDto from(Product product) {
        GetProductDto getProductDto = new GetProductDto();
        getProductDto.setId(product.getId());
        getProductDto.setTitle(product.getTitle());
        getProductDto.setDescription(product.getDescription());
        getProductDto.setImageUrl(product.getImageUrl());
        getProductDto.setPrice(product.getPrice());
        getProductDto.setCategoryName(product.getCategory().getName());

        return getProductDto;
    }
}
