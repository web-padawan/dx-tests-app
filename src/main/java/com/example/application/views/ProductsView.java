package com.example.application.views;

import java.util.List;

import com.example.application.components.ProductDetail;
import com.example.application.components.ProductDetailEmptyState;
import com.example.application.components.ProductList;
import com.example.application.domain.Product;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.dom.Style.BoxSizing;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.signals.Signal;
import com.vaadin.flow.signals.local.ValueSignal;

@Route(value = "products")
public class ProductsView extends Div {
    private final ValueSignal<List<Product>> products = new ValueSignal<>(Product.generateMockProducts());
    private final ValueSignal<Product> selectedProduct = new ValueSignal<>(null);

    public ProductsView() {
        setSizeFull();
        getStyle().setBoxSizing(BoxSizing.BORDER_BOX);
        getStyle().setPadding("var(--vaadin-padding-xl)");

        ProductList productList = new ProductList(products, selectedProduct);
        productList.addProductSelectedListener(event -> {
            selectedProduct.set(event.getProduct());
        });

        ProductDetailEmptyState emptyProduct = new ProductDetailEmptyState();

        ProductDetail productDetail = new ProductDetail(selectedProduct);
        productDetail.addCloseListener(event -> {
            selectedProduct.set(null);
        });

        /*
        Task 1.1
        - Convert the view to use a Master-Detail Layout instead of Horizontal Layout
        - Show the product details when a product is selected in the product list
        - Make sure the empty state content is shown when there is no product selected

        Task 1.2
        - Make the product details use a fixed size of 300px
        - Make the details open on top of the product list when the layout is narrower than 600px
        - Make the details fully cover the product list when opened on top of it
        - Make the details cover the full page when opened
        - Make the details render under the product list instead of next to it
        */

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
