package com.example.application.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private Long id;
    private String orderNumber;
    private String customerName;
    private LocalDate orderDate;
    private String status;

    public Order(Long id, String orderNumber, String customerName, LocalDate orderDate, String status) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.customerName = customerName;
        this.orderDate = orderDate;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static List<Order> generateMockOrders() {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(1L, "ORD-001", "Alice Johnson", LocalDate.of(2025, 3, 1), "Delivered"));
        orders.add(new Order(2L, "ORD-002", "Bob Smith", LocalDate.of(2025, 3, 5), "Processing"));
        orders.add(new Order(3L, "ORD-003", "Carol White", LocalDate.of(2025, 3, 10), "Shipped"));
        orders.add(new Order(4L, "ORD-004", "David Brown", LocalDate.of(2025, 3, 15), "Pending"));
        orders.add(new Order(5L, "ORD-005", "Eve Davis", LocalDate.of(2025, 3, 20), "Delivered"));
        orders.add(new Order(6L, "ORD-006", "Frank Miller", LocalDate.of(2025, 3, 22), "Processing"));
        orders.add(new Order(7L, "ORD-007", "Grace Wilson", LocalDate.of(2025, 3, 25), "Shipped"));
        orders.add(new Order(8L, "ORD-008", "Henry Moore", LocalDate.of(2025, 3, 28), "Pending"));
        orders.add(new Order(9L, "ORD-009", "Ivy Taylor", LocalDate.of(2025, 4, 1), "Delivered"));
        orders.add(new Order(10L, "ORD-010", "Jack Anderson", LocalDate.of(2025, 4, 3), "Processing"));
        return orders;
    }
}
