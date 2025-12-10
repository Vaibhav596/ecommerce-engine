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
    private String category;

    public static GetProductDto from(Product product) {
        GetProductDto GetProductDto = new GetProductDto();
        GetProductDto.setId(product.getId());
        GetProductDto.setDescription(product.getDescription());
        GetProductDto.setImageUrl(product.getImageUrl());
        GetProductDto.setPrice(product.getPrice());

        return GetProductDto;
    }
}
