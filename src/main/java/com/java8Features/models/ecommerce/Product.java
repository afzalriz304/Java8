package com.java8Features.models.ecommerce;

import com.java8Features.enums.ProductCategory;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
    private long id;
    private String name;
    private ProductCategory category;
    @With private double price;
}
