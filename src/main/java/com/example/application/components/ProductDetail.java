package com.example.application.components;

import com.example.application.domain.Product;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.signals.Signal;

public class ProductDetail extends Div {
    private final TextField nameField;
    private final TextField categoryField;
    private final NumberField priceField;

    public ProductDetail(Signal<Product> productSignal) {
        getStyle().setPadding("var(--vaadin-gap-m)");

        FormLayout formLayout = new FormLayout();

        nameField = new TextField("Name");
        nameField.setReadOnly(true);
        nameField.bindValue(
                productSignal.map((product) -> product != null ? product.getName() : ""),
                null);

        categoryField = new TextField("Category");
        categoryField.setReadOnly(true);
        categoryField.bindValue(
                productSignal.map((product) -> product != null ? product.getCategory() : ""),
                null);

        priceField = new NumberField("Price");
        priceField.setReadOnly(true);
        priceField.bindValue(
                productSignal.map((product) -> product != null ? product.getPrice() : null),
                null);

        Button closeButton = new Button("Close");
        closeButton.addClickListener(event -> fireEvent(new CloseEvent(this, false)));

        formLayout.add(nameField, categoryField, priceField, closeButton);

        add(formLayout);
    }

    public static class CloseEvent extends ComponentEvent<ProductDetail> {
        public CloseEvent(ProductDetail source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    public Registration addCloseListener(ComponentEventListener<CloseEvent> listener) {
        return addListener(CloseEvent.class, listener);
    }
}
