package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductResponseDto {
    private GetProductDto product;

    public static CreateProductResponseDto from(Product product) {
        CreateProductResponseDto dto = new CreateProductResponseDto();
        dto.setProduct(GetProductDto.from(product));
        return dto;
    }
}
