package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.dtos.products.GetProductDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductResponseDto {
    private GetProductDto product;
}
