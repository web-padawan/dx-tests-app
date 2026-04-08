package com.example.application.views;

import com.example.application.components.ProductDetail;
import com.example.application.components.ProductDetailPlaceholder;
import com.example.application.components.ProductList;
import com.example.application.domain.Product;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.signals.Signal;
import com.vaadin.flow.signals.local.ValueSignal;

@PageTitle("Product Layout View")
@Route(value = "product-layout")
public class ProductLayout extends HorizontalLayout {
    private final ValueSignal<Product> selectedProductSignal = new ValueSignal<>(null);

    public ProductLayout() {
        setSizeFull();

        ProductList productList = new ProductList(selectedProductSignal.asReadonly());
        productList.addProductSelectedListener(event -> {
            selectedProductSignal.set(event.getProduct());
        });
        add(productList);

        ProductDetailPlaceholder productDetailPlaceholder = new ProductDetailPlaceholder();
        productDetailPlaceholder.bindVisible(selectedProductSignal.map(product -> product == null));
        add(productDetailPlaceholder);

        ProductDetail productDetail = new ProductDetail(selectedProductSignal.asReadonly());
        productDetail.addCloseListener(event -> {
            selectedProductSignal.set(null);
        });

        Signal.effect(this, () -> {
            if (selectedProductSignal.get() != null) {
                add(productDetail);
            } else {
                remove(productDetail);
            }
        });
    }
}
