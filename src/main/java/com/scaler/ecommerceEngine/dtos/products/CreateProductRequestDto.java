package com.scaler.ecommerceEngine.dtos.products;

import com.scaler.ecommerceEngine.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDto {
    private CreateProductDto product;

    public Product toProduct(){
        return product.toProduct();
    }
}
