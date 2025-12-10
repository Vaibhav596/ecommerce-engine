package com.scaler.ecommerceEngine.services;

import com.scaler.ecommerceEngine.dtos.fakeStore.FakeStoreCreateProductRequestDto;
import com.scaler.ecommerceEngine.dtos.fakeStore.FakeStoreCreateProductResponseDto;
import com.scaler.ecommerceEngine.models.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Service("fakeStoreProductService")
//@Primary
public class ProductServiceFakestoreImpl implements ProductService {

    private RestTemplate restTemplate;

    public ProductServiceFakestoreImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreCreateProductRequestDto request = new FakeStoreCreateProductRequestDto();
        request.setCategory(product.getCategoryName());
        request.setTitle(product.getTitle());
        request.setImageUrl(product.getImageUrl());
        request.setDescription(product.getDescription());
        request.setPrice(product.getPrice());

        FakeStoreCreateProductResponseDto response = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                request,
                FakeStoreCreateProductResponseDto.class
        );

        Product product1 = new Product();
        product1.setId(response.getId());
        product1.setTitle(response.getTitle());
        product1.setDescription(response.getDescription());
        product1.setImageUrl(response.getImageUrl());
        product1.setCategoryName(response.getCategory());
        product1.setPrice(response.getPrice());

        return product1;
    }

    public List<Product> getAllProducts(){
        FakeStoreCreateProductResponseDto[] response = restTemplate.getForObject(
                "https://fakestoreapi.com/products",
                FakeStoreCreateProductResponseDto[].class
        );

        List<FakeStoreCreateProductResponseDto> responseDtoList = Stream.of(response).toList();

        List<Product> products = new ArrayList<>();

        for (FakeStoreCreateProductResponseDto fakeStoreCreateProductResponseDto : responseDtoList) {
            products.add(fakeStoreCreateProductResponseDto.toProduct());
        }

        return products;
    }

    @Override
    public Product partialUpdateProduct(Long productId, Product product){
        HttpEntity<FakeStoreCreateProductRequestDto> requestEntity = new HttpEntity<>(FakeStoreCreateProductRequestDto.fromProduct(product));
        HttpEntity<FakeStoreCreateProductResponseDto> responseEntity = restTemplate.exchange(
                "https://fakestoreapi.com/products" + productId,
                HttpMethod.PATCH,
                requestEntity,
                FakeStoreCreateProductResponseDto.class
        );
        return responseEntity.getBody().toProduct();
    }

}
