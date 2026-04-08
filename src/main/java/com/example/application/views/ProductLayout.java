package com.example.application.views;

import com.example.application.components.ProductDetail;
import com.example.application.components.ProductList;
import com.example.application.domain.Product;
import com.vaadin.flow.component.masterdetaillayout.MasterDetailLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.signals.local.ValueSignal;

@PageTitle("Product Layout View")
@Route(value = "product-layout")
public class ProductLayout extends MasterDetailLayout {
    private final ValueSignal<Product> selectedProductSignal = new ValueSignal<>(null);

    public ProductLayout() {
        ProductList productList = new ProductList(selectedProductSignal.asReadonly());
        productList.addProductSelectedListener(event -> {
            selectedProductSignal.set(event.getProduct());
        });

        ProductDetail productDetail = new ProductDetail(selectedProductSignal.asReadonly());
        productDetail.bindVisible(selectedProductSignal.map(product -> product != null));
        productDetail.addCloseListener(event -> {
            selectedProductSignal.set(null);
        });

        setMaster(productList);
        setDetail(productDetail);
        setSizeFull();
    }
}
