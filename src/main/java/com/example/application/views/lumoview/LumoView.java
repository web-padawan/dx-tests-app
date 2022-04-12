package com.example.application.views.lumoview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Lumo View")
@Route(value = "lumo-view", layout = MainLayout.class)
public class LumoView extends VerticalLayout {

    public LumoView() {

    }

}
