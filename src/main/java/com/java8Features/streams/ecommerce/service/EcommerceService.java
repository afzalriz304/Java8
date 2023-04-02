package com.java8Features.streams.ecommerce.service;

import com.java8Features.enums.OrderStatus;
import com.java8Features.enums.ProductCategory;
import com.java8Features.models.ecommerce.Product;

import java.util.List;
import java.util.Optional;

public interface EcommerceService {
    List<Product> fetchProductByCategoryAndPrice(ProductCategory category, double price);

    List<Product> fetchProductByCategoryAndApplyDiscount(ProductCategory category, double discount);

    List<String> fetchNameOfProducts();

    List<Product> fetchProductsFromOrderListByTier(Integer tier);

    List<ProductCategory> fetchNumberOfCategoryOfProductList();

    Optional<Product> fetchCheapestProductFromList();

    List<Product> sortProductByPrice();

    void fetchProductListFromOrderByOrderStatus(OrderStatus orderStatus);

}
