package com.example.application.components;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ProductDetailPlaceholder extends VerticalLayout {
    public ProductDetailPlaceholder() {
        Span message = new Span("Please select a product to view details");
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        add(message);
    }
}
