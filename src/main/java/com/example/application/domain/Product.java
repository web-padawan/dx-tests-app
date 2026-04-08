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
    private LocalDate dateAdded;

    public Product(Long id, String name, String category, double price, LocalDate dateAdded) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.dateAdded = dateAdded;
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

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public static List<Product> generateMockProducts() {
        List<Product> products = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        products.add(new Product(1L, "Apple", "Fruit", 1.99, LocalDate.parse("2019-01-01", formatter)));
        products.add(new Product(2L, "Banana", "Fruit", 2.99, LocalDate.parse("2019-01-02", formatter)));
        products.add(new Product(3L, "Carrot", "Vegetable", 3.99, LocalDate.parse("2019-01-03", formatter)));
        products.add(new Product(4L, "Eggplant", "Vegetable", 5.99, LocalDate.parse("2019-01-05", formatter)));
        products.add(new Product(5L, "Orange", "Fruit", 2.49, LocalDate.parse("2019-01-06", formatter)));
        products.add(new Product(6L, "Broccoli", "Vegetable", 4.29, LocalDate.parse("2019-01-07", formatter)));
        products.add(new Product(7L, "Grapes", "Fruit", 3.79, LocalDate.parse("2019-01-08", formatter)));
        products.add(new Product(8L, "Cucumber", "Vegetable", 2.89, LocalDate.parse("2019-01-09", formatter)));
        products.add(new Product(9L, "Strawberry", "Fruit", 4.99, LocalDate.parse("2019-01-10", formatter)));
        products.add(new Product(10L, "Tomato", "Vegetable", 2.19, LocalDate.parse("2019-01-11", formatter)));
        products.add(new Product(11L, "Pineapple", "Fruit", 3.69, LocalDate.parse("2019-01-12", formatter)));
        products.add(new Product(12L, "Spinach", "Vegetable", 2.79, LocalDate.parse("2019-01-13", formatter)));
        products.add(new Product(13L, "Blueberry", "Fruit", 6.49, LocalDate.parse("2019-01-14", formatter)));
        products.add(new Product(14L, "Bell Pepper", "Vegetable", 1.99, LocalDate.parse("2019-01-15", formatter)));
        products.add(new Product(15L, "Watermelon", "Fruit", 7.99, LocalDate.parse("2019-01-16", formatter)));
        products.add(new Product(16L, "Zucchini", "Vegetable", 2.49, LocalDate.parse("2019-01-17", formatter)));
        products.add(new Product(17L, "Mango", "Fruit", 4.79, LocalDate.parse("2019-01-18", formatter)));
        products.add(new Product(18L, "Asparagus", "Vegetable", 3.29, LocalDate.parse("2019-01-19", formatter)));
        products.add(new Product(19L, "Cherry", "Fruit", 3.99, LocalDate.parse("2019-01-20", formatter)));
        products.add(new Product(20L, "Potato", "Vegetable", 1.49, LocalDate.parse("2019-01-21", formatter)));
        products.add(new Product(21L, "Pear", "Fruit", 2.59, LocalDate.parse("2019-01-22", formatter)));
        products.add(new Product(22L, "Cantaloupe", "Fruit", 3.99, LocalDate.parse("2019-01-23", formatter)));
        products.add(new Product(23L, "Cauliflower", "Vegetable", 2.19, LocalDate.parse("2019-01-24", formatter)));
        products.add(new Product(24L, "Lemon", "Fruit", 1.79, LocalDate.parse("2019-01-25", formatter)));
        products.add(new Product(25L, "Cabbage", "Vegetable", 1.69, LocalDate.parse("2019-01-26", formatter)));
        products.add(new Product(26L, "Raspberry", "Fruit", 5.29, LocalDate.parse("2019-01-27", formatter)));
        products.add(new Product(27L, "Onion", "Vegetable", 1.29, LocalDate.parse("2019-01-28", formatter)));
        products.add(new Product(28L, "Kiwi", "Fruit", 2.69, LocalDate.parse("2019-01-29", formatter)));
        products.add(new Product(29L, "Green Bean", "Vegetable", 2.39, LocalDate.parse("2019-01-30", formatter)));
        products.add(new Product(30L, "Blackberry", "Fruit", 4.49, LocalDate.parse("2019-01-31", formatter)));
        products.add(new Product(31L, "Sweet Potato", "Vegetable", 1.99, LocalDate.parse("2019-02-01", formatter)));
        products.add(new Product(32L, "Peach", "Fruit", 3.49, LocalDate.parse("2019-02-02", formatter)));
        products.add(new Product(33L, "Celery", "Vegetable", 1.89, LocalDate.parse("2019-02-03", formatter)));
        products.add(new Product(34L, "Grapefruit", "Fruit", 2.99, LocalDate.parse("2019-02-04", formatter)));
        products.add(new Product(35L, "Radish", "Vegetable", 1.29, LocalDate.parse("2019-02-05", formatter)));
        products.add(new Product(36L, "Apricot", "Fruit", 3.99, LocalDate.parse("2019-02-06", formatter)));
        products.add(new Product(37L, "Brussels Sprout", "Vegetable", 2.49, LocalDate.parse("2019-02-07", formatter)));
        products.add(new Product(38L, "Artichoke", "Vegetable", 3.99, LocalDate.parse("2019-02-09", formatter)));
        products.add(new Product(39L, "Lime", "Fruit", 1.49, LocalDate.parse("2019-02-10", formatter)));
        products.add(new Product(40L, "Beet", "Vegetable", 1.99, LocalDate.parse("2019-02-11", formatter)));
        products.add(new Product(41L, "Plum", "Fruit", 2.99, LocalDate.parse("2019-02-12", formatter)));
        products.add(new Product(42L, "Corn", "Vegetable", 1.49, LocalDate.parse("2019-02-13", formatter)));
        products.add(new Product(43L, "Pomegranate", "Fruit", 3.99, LocalDate.parse("2019-02-14", formatter)));
        products.add(new Product(44L, "Garlic", "Vegetable", 1.29, LocalDate.parse("2019-02-15", formatter)));
        products.add(new Product(45L, "Papaya", "Fruit", 4.99, LocalDate.parse("2019-02-16", formatter)));
        products.add(new Product(46L, "Green Onion", "Vegetable", 1.49, LocalDate.parse("2019-02-17", formatter)));
        products.add(new Product(47L, "Ginger", "Vegetable", 1.99, LocalDate.parse("2019-02-19", formatter)));
        products.add(new Product(48L, "Parsley", "Vegetable", 1.29, LocalDate.parse("2019-02-20", formatter)));
        products.add(new Product(49L, "Parsnip", "Vegetable", 1.99, LocalDate.parse("2019-02-21", formatter)));
        products.add(new Product(50L, "Peas", "Vegetable", 1.99, LocalDate.parse("2019-02-24", formatter)));

        return products;
    }
}
