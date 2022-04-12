package com.example.application.views.dialogview;

import com.example.application.views.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Dialog View (Java)")
@Route(value = "dialog-view-java", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class DialogView extends VerticalLayout {

    public DialogView() {

    }

}
