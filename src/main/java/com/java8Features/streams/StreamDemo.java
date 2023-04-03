package com.java8Features.streams;

import com.java8Features.enums.OrderStatus;
import com.java8Features.enums.ProductCategory;
import com.java8Features.models.ecommerce.Order;
import com.java8Features.models.ecommerce.Product;
import com.java8Features.streams.ecommerce.serviceImpl.EcommerceServiceImpl;
import com.java8Features.utils.StreamUtil;

import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamDemo {

    private EcommerceServiceImpl ecommerceService;

    public StreamDemo() {
        ecommerceService = new EcommerceServiceImpl();
    }

    public static void main(String[] args) {
        StreamDemo streamDemo = new StreamDemo();
        StreamUtil<Product> productStreamUtil = new StreamUtil();
        StreamUtil<Order> orderStreamUtil = new StreamUtil();

        /**
         * --------------------------FILTER--------------------------------
         * Exercise 1-> Obtain a list of products belongs to category “Cloth” with price <= 1500
         */
        System.out.println("Obtain a list of products belongs to category “Cloth” with price <= 1500");
        List<Product> list0 = streamDemo.ecommerceService
                .fetchProductByCategoryAndPrice(ProductCategory.CLOTH, 1500);
        productStreamUtil.print(list0);

        /**
         *--------------------------MAP--------------------------------
         * Exercise 2->Obtain a list of product name
         */
        System.out.println("Obtain a list of product name");
        StreamUtil<String> stringStreamUtil = new StreamUtil();
        List<String> list2 = streamDemo.ecommerceService
                .fetchNameOfProducts();
        stringStreamUtil.print(list2);
        /**
         *--------------------------MAP--------------------------------
         * Exercise 3->Obtain a list of product with category = “Cloth” and then apply 10% discount
         */
        System.out.println("Obtain a list of product with category = “Cloth” and then apply 10% discount");
        List<Product> list3 = streamDemo.ecommerceService
                .fetchProductByCategoryAndApplyDiscount(ProductCategory.CLOTH, 10);
        productStreamUtil.print(list3);

        /**
         * --------------------------FLAT MAP---------------------------
         * Exercise 4 -> flat a multiple stream into a single stream
         */
        System.out.println("flat a multiple stream into a single stream");
        StreamUtil<Integer> integerStreamUtil = new StreamUtil<>();
        List<Integer> l1 = Arrays.asList(1, 2, 3);
        List<Integer> l2 = Arrays.asList(4, 5, 6);
        List<Integer> l3 = Arrays.asList(7, 8, 9);
        List<List<Integer>> matrix = Arrays.asList(l1, l2, l3);
        List<Integer> flatList = matrix.stream()
                .flatMap(mat -> mat.stream())
                .collect(Collectors.toList());
        integerStreamUtil.print(flatList);

        /**
         * --------------------------FLAT MAP---------------------------
         * Exercise 5 -> Obtain a list of products ordered by customer of tier 2
         */
        System.out.println("Obtain a list of products ordered by customer of tier 2");
        List<Product> listOfProductForTier2 = streamDemo.ecommerceService.fetchProductsFromOrderListByTier(2);
        productStreamUtil.print(listOfProductForTier2);

        /**
         * ------------------distinct
         * Exercise 6 -> Obtain a list of category in product list
         */
        System.out.println("Obtain a list of category in product list");
        List<ProductCategory> productCategories = streamDemo.ecommerceService.fetchNumberOfCategoryOfProductList();
        StreamUtil<ProductCategory> productCategoryStreamUtil = new StreamUtil<>();
        productCategoryStreamUtil.print(productCategories);

        /**
         * -----------------------min---------------------------
         * Exercise 7 -> Obtain the cheapest Product from product list
         */
        System.out.println("Obtain the cheapest Product from product list");
        Optional<Product> cheapestProduct = streamDemo.ecommerceService.fetchCheapestProductFromList();
        System.out.println(cheapestProduct);

        /**
         * -----------------------max---------------------------
         * Exercise 7 -> Obtain the cheapest Product from product list
         */
        System.out.println("Obtain the highest price Product from product list");
        Optional<Product> highPriceProduct = streamDemo.ecommerceService.fetchHighestPriceProductFromList();
        System.out.println(highPriceProduct);

        /**
         * -----------------------Sorted---------------------------
         * Exercise 9 -> Obtain Products sorted by price
         */
        System.out.println("Obtain the cheapest Product from product list");
        List<Product> sortedList = streamDemo.ecommerceService.sortProductByPrice();
        productStreamUtil.print(sortedList);

        /**
         * --------------------peek------------------
         * Exercise 10 -> fetch order name along with its product list
         */
        System.out.println("fetch order name along with its product list");
        streamDemo.ecommerceService.fetchProductListFromOrderByOrderStatus(OrderStatus.PLACED);


        /**
         * --------------------anyMatch------------------
         * Exercise 12 -> Check if any product belong to product category of beauty
         */
        boolean result = streamDemo.ecommerceService.isProductCategoryPresent(ProductCategory.BEAUTY);
        System.out.println("Check if any product belong to product category of cloth : " + result);

        /**
         * --------------------anyMatch------------------
         * Exercise 13 -> fetch orders belong to product category of cloth
         */
        System.out.println("fetch orders belong to product category of cloth");
        List<Order> orderList = streamDemo.ecommerceService.fetchOrdersByProductCategory(ProductCategory.CLOTH);
        orderStreamUtil.print(orderList);

        /**
         * --------------------sum------------------
         * Exercise 14 -> total value of product belong to product category of cloth
         */
        double totalValue = streamDemo.ecommerceService.totalValueOfProductsByProductCategory(ProductCategory.CLOTH);
        System.out.println("total value of product belong to product category of cloth " + totalValue);

        /**
         * --------------------summaryStatistic------------------
         * Exercise 14 -> total value of product belong to product category of cloth
         */
        DoubleSummaryStatistics doubleSummaryStatistics = streamDemo.ecommerceService.productPriceStatistic();
        System.out.println("total value of product belong to product category of cloth " + doubleSummaryStatistics);

    }
}
