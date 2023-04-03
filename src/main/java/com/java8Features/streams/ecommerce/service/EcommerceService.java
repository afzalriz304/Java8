package com.java8Features.streams.ecommerce.service;

import com.java8Features.enums.OrderStatus;
import com.java8Features.enums.ProductCategory;
import com.java8Features.models.ecommerce.Order;
import com.java8Features.models.ecommerce.Product;

import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

public interface EcommerceService {
    List<Product> fetchProductByCategoryAndPrice(ProductCategory category, double price);

    List<Product> fetchProductByCategoryAndApplyDiscount(ProductCategory category, double discount);

    List<String> fetchNameOfProducts();

    List<Product> fetchProductsFromOrderListByTier(Integer tier);

    List<ProductCategory> fetchNumberOfCategoryOfProductList();

    Optional<Product> fetchCheapestProductFromList();

    Optional<Product> fetchHighestPriceProductFromList();

    List<Product> sortProductByPrice();

    void fetchProductListFromOrderByOrderStatus(OrderStatus orderStatus);

    List<Order> fetchOrdersByProductCategory(ProductCategory productCategory);

    boolean isProductCategoryPresent(ProductCategory productCategory);

    double totalValueOfProductsByProductCategory(ProductCategory productCategory);

    DoubleSummaryStatistics productPriceStatistic();
}
