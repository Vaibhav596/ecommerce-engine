package com.scaler.ecommerceEngine.dtos.products;

import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class GetAllProductsResponseDto {
    private List<GetProductDto> products;
}
