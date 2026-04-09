package com.example.application.components;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Style.TextAlign;

public class ProductDetailEmptyState extends VerticalLayout {
    public ProductDetailEmptyState() {

        Span message = new Span("Please select a product to view details");
        message.getStyle().setTextAlign(TextAlign.CENTER);

        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);
        getStyle().setPadding("var(--vaadin-gap-m)");
        setSizeFull();
        add(message);
    }
}
