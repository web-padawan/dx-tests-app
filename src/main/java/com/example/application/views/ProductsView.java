package com.example.application.views;

import java.util.List;

import com.example.application.components.ProductDetail;
import com.example.application.components.ProductDetailEmptyState;
import com.example.application.components.ProductList;
import com.example.application.domain.Product;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.signals.Signal;
import com.vaadin.flow.signals.local.ValueSignal;

@Route(value = "products")
public class ProductsView extends Div {
    private final ValueSignal<List<Product>> products = new ValueSignal<>(Product.generateMockProducts());
    private final ValueSignal<Product> selectedProduct = new ValueSignal<>(null);

    public ProductsView() {
        setSizeFull();

        ProductList productList = new ProductList(products, selectedProduct);
        productList.addProductSelectedListener(event -> {
            selectedProduct.set(event.getProduct());
        });

        ProductDetailEmptyState emptyProduct = new ProductDetailEmptyState();

        ProductDetail productDetail = new ProductDetail(selectedProduct);
        productDetail.addCloseListener(event -> {
            selectedProduct.set(null);
        });

        // Layout Configuration Start
        HorizontalLayout productLayout = new HorizontalLayout();
        productLayout.setHeightFull();
        productLayout.add(productList, emptyProduct);

        emptyProduct.bindVisible(selectedProduct.map(product -> product == null));

        Signal.effect(productLayout, () -> {
            if (selectedProduct.get() != null) {
                productLayout.add(productDetail);
            } else {
                productLayout.remove(productDetail);
            }
        });
        // Layout Configuration End

        add(productLayout);
    }
}
