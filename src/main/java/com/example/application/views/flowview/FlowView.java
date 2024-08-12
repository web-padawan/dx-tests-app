package com.example.application.views.flowview;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Flow View")
@Menu(order = 1)
@Route(value = "flow-view")
public class FlowView extends VerticalLayout {

    public FlowView() {
        Button button = new Button("Click me");
        add(button);
    }
}
