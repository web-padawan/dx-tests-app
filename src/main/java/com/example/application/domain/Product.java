package com.example.application.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private Long id;
    private String name;
    private String category;
    private double price;
    private List<Long> orderIds;

    public Product(Long id, String name, String category, double price, List<Long> orderIds) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.orderIds = orderIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<Long> getOrderIds() {
        return orderIds;
    }

    public void setOrderIds(List<Long> orderIds) {
        this.orderIds = orderIds;
    }

    public static List<Product> generateMockProducts() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Apple", "Fruit", 1.99, List.of(1L, 3L, 7L)));
        products.add(new Product(2L, "Banana", "Fruit", 2.99, List.of(1L, 5L)));
        products.add(new Product(3L, "Carrot", "Vegetable", 3.99, List.of(1L, 2L)));
        products.add(new Product(4L, "Eggplant", "Vegetable", 5.99, List.of(2L, 6L)));
        products.add(new Product(5L, "Orange", "Fruit", 2.49, List.of(2L, 3L, 9L)));
        products.add(new Product(6L, "Broccoli", "Vegetable", 4.29, List.of(3L, 8L)));
        products.add(new Product(7L, "Grapes", "Fruit", 3.79, List.of(3L, 4L)));
        products.add(new Product(8L, "Cucumber", "Vegetable", 2.89, List.of(4L, 10L)));
        products.add(new Product(9L, "Strawberry", "Fruit", 4.99, List.of(4L, 5L)));
        return products;
    }
}
