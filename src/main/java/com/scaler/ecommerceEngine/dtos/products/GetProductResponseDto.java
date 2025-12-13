package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.dtos.products.GetProductDto;
import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetProductResponseDto {
    private GetProductDto product;
}
