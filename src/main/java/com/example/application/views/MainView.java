package com.example.application.views;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

@Route("")
public class MainView extends VerticalLayout {
  public MainView() {
    add(new RouterLink("Products", ProductsView.class));
    add(new RouterLink("Orders", OrdersView.class));
  }
}
