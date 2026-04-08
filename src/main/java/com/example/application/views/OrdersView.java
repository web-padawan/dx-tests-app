package com.example.application.views;

import java.util.List;

import com.example.application.components.OrderList;
import com.example.application.components.ProductDetail;
import com.example.application.components.ProductList;
import com.example.application.domain.Order;
import com.example.application.domain.Product;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.signals.Signal;
import com.vaadin.flow.signals.local.ValueSignal;

@Route(value = "orders")
public class OrdersView extends Div {

    private final ValueSignal<Order> selectedOrder = new ValueSignal<>(null);
    private final ValueSignal<Product> selectedProduct = new ValueSignal<>(null);
    private final Signal<List<Product>> selectedOrderProducts = Signal.computed(() -> {
        Order order = selectedOrder.get();
        if (order == null) {
            return List.of();
        }
        return Product.generateMockProducts()
                .stream()
                .filter(p -> p.getOrderIds().contains(order.getId()))
                .toList();
    });

    public OrdersView() {
        setSizeFull();

        OrderList orderList = new OrderList(selectedOrder.asReadonly());
        orderList.addOrderSelectedListener(event -> {
            selectedOrder.set(event.getOrder());
            selectedProduct.set(null);
        });

        ProductList productList = new ProductList(selectedOrderProducts, selectedProduct);
        productList.addProductSelectedListener(event -> {
            selectedProduct.set(event.getProduct());
        });

        ProductDetail productDetail = new ProductDetail(selectedProduct);
        productDetail.addCloseListener(event -> {
            selectedProduct.set(null);
        });

        // Main Layout Configuration Start
        HorizontalLayout productLayout = new HorizontalLayout();
        productLayout.setSizeFull();
        productLayout.add(productList);
        Signal.effect(productLayout, () -> {
            if (selectedProduct.get() != null) {
                productLayout.add(productDetail);
            } else {
                productLayout.remove(productDetail);
            }
        });
        // Main Layout Configuration End

        // Inner Layout Configuration Start
        HorizontalLayout orderLayout = new HorizontalLayout();
        orderLayout.setSizeFull();
        orderLayout.add(orderList);
        Signal.effect(this, () -> {
            if (selectedOrder.get() != null) {
                orderLayout.add(productLayout);
            } else {
                orderLayout.remove(productLayout);
            }
        });
        // Inner Layout Configuration End

        add(orderLayout);
    }
}
