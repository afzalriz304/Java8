package com.java8Features.utils;

import com.java8Features.enums.OrderStatus;
import com.java8Features.enums.ProductCategory;
import com.java8Features.models.ecommerce.Customer;
import com.java8Features.models.ecommerce.Order;
import com.java8Features.models.ecommerce.Product;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ModelUtil {
    public static List<Product> createProductsList1() {
        Product product1 = new Product(1L, "prod1", ProductCategory.CLOTH, 600);
        Product product2 = new Product(2L, "prod2", ProductCategory.ELECTRONIC, 6000);
        Product product3 = new Product(3L, "prod3", ProductCategory.SHOE, 2250);
        Product product4 = new Product(4L, "prod4", ProductCategory.CLOTH, 1500);
        Product product5 = new Product(5L, "prod4", ProductCategory.CLOTH, 1600);
        return Arrays.asList(product1, product2, product3, product4, product5);
    }

    public static List<Product> createProductsList2() {
        Product product1 = new Product(6L, "prod6", ProductCategory.CLOTH, 600);
        Product product2 = new Product(7L, "prod7", ProductCategory.BEAUTY, 6000);
        Product product3 = new Product(8L, "prod8", ProductCategory.PHONE, 22500);
        Product product4 = new Product(9L, "prod9", ProductCategory.HOME_APPLIANCE, 15000);
        Product product5 = new Product(10L, "prod10", ProductCategory.ELECTRONIC, 1600);
        return Arrays.asList(product1, product2, product3, product4, product5);
    }

    public static List<Product> createProductsList3() {
        Product product1 = new Product(11L, "prod11", ProductCategory.PHONE, 600);
        Product product2 = new Product(12L, "prod12", ProductCategory.SHOE, 6000);
        Product product3 = new Product(13L, "prod13", ProductCategory.BEAUTY, 2250);
        Product product4 = new Product(14L, "prod14", ProductCategory.BEAUTY, 1500);
        Product product5 = new Product(15L, "prod15", ProductCategory.HOME_APPLIANCE, 1600);
        return Arrays.asList(product1, product2, product3, product4, product5);
    }

    public static List<Order> createOrders() {
        Customer customer1 = new Customer(1L, "customer1", 2);
        Customer customer2 = new Customer(2L, "customer2", 1);
        Customer customer3 = new Customer(3L, "customer3", 2);

        Order order1 = new Order(1L, OrderStatus.PLACED, new Date(), new Date()
                , createProductsList1(), customer1);


        Order order2 = new Order(2L, OrderStatus.DELIVERED, new Date(), new Date()
                , createProductsList2(), customer2);


        Order order3 = new Order(3L, OrderStatus.SHIPPED, new Date(), new Date()
                , createProductsList3(), customer3);

        return Arrays.asList(order1, order2, order3);
    }

}
