//package com.scaler.ecommerceEngine.dtos;
//
//import com.scaler.ecommerceEngine.models.Product;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//public class GetProductResponseDto {
//    private GetProductDto product;
//    private Long id;
//    private String title;
//    private double price;
//    private String imageUrl;
//    private String description;
//    private String category;
//
//    public static GetProductResponseDto from(Product product) {
//        GetProductResponseDto getProductResponseDto = new GetProductResponseDto();
//        getProductResponseDto.setId(product.getId());
//        getProductResponseDto.setDescription(product.getDescription());
//        getProductResponseDto.setImageUrl(product.getImageUrl());
//        getProductResponseDto.setPrice(product.getPrice());
//
//        return getProductResponseDto;
//    }
//}
