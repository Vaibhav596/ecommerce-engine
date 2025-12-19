package com.scaler.ecommerceEngine.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    private String description;
//    @OneToMany(mappedBy = "category")
//    private List<Product> featuredProducts;

    @OneToMany(mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Product> products;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Subcategory subcategory;
}
