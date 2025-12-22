package com.scaler.ecommerceEngine.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Getter
@Setter
@Entity
public class Category extends BaseModel {
    private String name;
    @Basic(fetch = FetchType.LAZY)
    private String description;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Product> featuredProducts;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "category", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Fetch(FetchMode.JOIN)
    private List<Product> products;

    @OneToOne(cascade = {CascadeType.PERSIST})
    private Subcategory subcategory;

    private int countOfProducts;
}
