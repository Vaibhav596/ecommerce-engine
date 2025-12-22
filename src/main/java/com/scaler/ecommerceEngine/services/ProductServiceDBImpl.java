package com.scaler.ecommerceEngine.services;

import com.scaler.ecommerceEngine.exceptions.ProductNotFoundException;
import com.scaler.ecommerceEngine.models.Category;
import com.scaler.ecommerceEngine.models.Product;
import com.scaler.ecommerceEngine.repositories.CategoryRepository;
import com.scaler.ecommerceEngine.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("dbProductService")
public class ProductServiceDBImpl implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceDBImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(Product product) {
        // #Commenting below part because cascades handles it

        String categoryName = product.getCategory().getName();
        Optional<Category> category = categoryRepository.findByName(categoryName);

        Category toBePutInProduct = null;

        if(category.isEmpty()) {
            Category toSaveCategory = new Category();
            toSaveCategory.setName(categoryName);
            toBePutInProduct = categoryRepository.save(toSaveCategory);
        } else {
            toBePutInProduct = category.get();
        }

        product.setCategory(toBePutInProduct);

        categoryRepository.save(toBePutInProduct);

        Product savedProduct = productRepository.save(product);

        return savedProduct;
    }

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException {
        Optional<Product> productToUpdateOptional = productRepository.findById(productId);

        if(productToUpdateOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }

        Product productToUpdate = productToUpdateOptional.get();



        if (product.getDescription() != null) {
            productToUpdate.setDescription(product.getDescription());
        }

        if(product.getPrice() != null) {
            productToUpdate.setPrice(product.getPrice());
        }

        if (product.getTitle() != null) {
            productToUpdate.setTitle(product.getTitle());
        }

        if (product.getCategory() != null) {
            String categoryName = product.getCategory().getName();
            Optional<Category> category = categoryRepository.findByName(categoryName);

            Category toBePutInProduct = null;

            if(category.isEmpty()) {
                Category toSaveCategory = new Category();
                toSaveCategory.setName(categoryName);
                toBePutInProduct = categoryRepository.save(toSaveCategory);
            } else {
                toBePutInProduct = category.get();
            }

            productToUpdate.setCategory(toBePutInProduct);
        }

        return productRepository.save(productToUpdate);
    }
}
