package com.example.application.components;

import com.example.application.domain.Order;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.signals.Signal;

public class OrderList extends VerticalLayout {

    public OrderList(Signal<Order> selectedOrderSignal) {
        Grid<Order> grid = new Grid<>();
        grid.addColumn(Order::getOrderNumber).setHeader("Order #");
        grid.addColumn(Order::getCustomerName).setHeader("Customer");
        grid.addColumn(Order::getOrderDate).setHeader("Date");
        grid.addColumn(Order::getStatus).setHeader("Status");
        grid.setItems(Order.generateMockOrders());
        grid.setHeightFull();
        grid.asSingleSelect().bindValue(selectedOrderSignal, (order) -> {
            fireEvent(new OrderSelectedEvent(this, order));
        });

        add(grid);
        setHeightFull();
        setSpacing(false);
        setPadding(false);
    }

    public static class OrderSelectedEvent extends ComponentEvent<OrderList> {
        private final Order order;

        public OrderSelectedEvent(OrderList source, Order order) {
            super(source, false);
            this.order = order;
        }

        public Order getOrder() {
            return order;
        }
    }

    public Registration addOrderSelectedListener(
            ComponentEventListener<OrderSelectedEvent> listener) {
        return addListener(OrderSelectedEvent.class, listener);
    }
}
