package com.java8Features.streams.ecommerce.serviceImpl;

import com.java8Features.enums.OrderStatus;
import com.java8Features.enums.ProductCategory;
import com.java8Features.models.ecommerce.Order;
import com.java8Features.models.ecommerce.Product;
import com.java8Features.streams.ecommerce.service.EcommerceService;
import com.java8Features.utils.ModelUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class EcommerceServiceImpl implements EcommerceService {

    private List<Product> originalProductList;
    private List<Order> originalOrderList;

    public EcommerceServiceImpl() {
        originalProductList = ModelUtil.createProductsList1();
        originalOrderList = ModelUtil.createOrders();
    }

    /**
     * Obtain a list of products belongs to category “Cloth” with price <= 1500
     *
     * @param category
     * @param price
     * @return
     */
    @Override
    public List<Product> fetchProductByCategoryAndPrice(ProductCategory category, double price) {

        return originalProductList.stream()
                .filter(product -> product.getCategory().equals(ProductCategory.CLOTH))
                .filter(product -> product.getPrice() <= 1500)
                .collect(Collectors.toList());
    }

    /**
     * Obtain a list of product with category = “Cloth” and then apply 10% discount
     *
     * @param category
     * @param discount
     * @return
     */
    @Override
    public List<Product> fetchProductByCategoryAndApplyDiscount(ProductCategory category, double discount) {
        //List<Product> originalList = ModelUtil.createProducts();
        Optional.of(discount).ifPresentOrElse(
                (value) -> {
                    if (value > 100) {
                        throw new RuntimeException("Invalid Value for discount");
                    }
                },
                () -> {
                    throw new RuntimeException("Invalid Value for discount");
                });
        return originalProductList.stream()
                .filter(product -> product.getCategory().equals(ProductCategory.CLOTH))
                .map(product -> product.withPrice(product.getPrice() * ((100 - discount) / 100)))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> fetchNameOfProducts() {
        return originalProductList.stream()
                .map(product -> product.getName())
                .collect(Collectors.toList());
    }

    /**
     * ------------------------flat map---------------------
     * Obtain a list of products ordered by customer of tier 2
     *
     * @param tier
     * @return
     */
    @Override
    public List<Product> fetchProductsFromOrderListByTier(Integer tier) {

        return originalOrderList.stream()
                .filter(order -> order.getCustomer().getTier() == 2)
                .flatMap(order -> order.getProductList().stream())
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductCategory> fetchNumberOfCategoryOfProductList() {
        return originalProductList.stream()
                .map(product -> product.getCategory())
                .distinct()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Product> fetchCheapestProductFromList() {
        return originalProductList.stream()
                .min(Comparator.comparing(Product::getPrice));
    }

    @Override
    public List<Product> sortProductByPrice() {
        return originalProductList.stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public void fetchProductListFromOrderByOrderStatus(OrderStatus orderStatus) {
        originalOrderList.stream()
                .filter(order -> order.getOrderStatus().equals(orderStatus))
                .peek(order -> System.out.println(order.getOrderStatus()))
                .flatMap(order -> order.getProductList().stream())
                .collect(Collectors.toList())
                .stream().forEach(System.out::println);
    }

}
