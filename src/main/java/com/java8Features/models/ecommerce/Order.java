package com.java8Features.models.ecommerce;

import com.java8Features.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Order {
    public long orderId;
    public OrderStatus orderStatus;
    public Date orderDate;
    public Date deliveryDate;
    public List<Product> productList;
    public Customer customer;
}
