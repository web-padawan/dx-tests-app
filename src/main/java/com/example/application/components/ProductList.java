package com.example.application.components;

import com.example.application.domain.Product;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.signals.Signal;

public class ProductList extends VerticalLayout {

    public ProductList(Signal<Product> selectedProductSignal) {
        Grid<Product> grid = new Grid<>();
        grid.addColumn(Product::getName).setHeader("Name");
        grid.addColumn(Product::getCategory).setHeader("Category");
        grid.addColumn(Product::getDateAdded).setHeader("Date Added");
        grid.addColumn(Product::getPrice).setHeader("Price");
        grid.setItems(Product.generateMockProducts());
        grid.setHeightFull();
        grid.asSingleSelect().bindValue(selectedProductSignal, (product) -> {
            fireEvent(new ProductSelectedEvent(this, product));
        });

        add(grid);
        setHeightFull();
        setSpacing(false);
        setPadding(false);
    }

    public static class ProductSelectedEvent extends ComponentEvent<ProductList> {
        private final Product product;

        public ProductSelectedEvent(ProductList source, Product product) {
            super(source, false);
            this.product = product;
        }

        public Product getProduct() {
            return product;
        }
    }

    public Registration addProductSelectedListener(
            ComponentEventListener<ProductSelectedEvent> listener) {
        return addListener(ProductSelectedEvent.class, listener);
    }
}
