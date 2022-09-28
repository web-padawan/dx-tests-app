package com.example.application.views.tabsheetview;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("TabSheet View")
@Route(value = "tabsheet-view")
@RouteAlias(value = "")
public class TabSheetView extends VerticalLayout {

    /**
     * Tasks to complete:
     *
     * 1.
     * 1.1. Add a TabSheet to the view (make it 100% wide)
     * 1.2. Add tabs with captions “Analytics”, “Customers”, “Dashboards”, and anything (like lorem ipsum) as the content
     * 1.3. Add a disabled tab with the caption “Orders” and anything as the content
     * 
     * 2.
     * 2.1. Add a button that adds a new tab "Documents" before the "Dashboards" tab (without counting its index)
     * 2.2. Add a button that removes the first tab
     * 2.3. When changing a tab, print the index of the previously selected tab
     * 
     * 3.
     * 3.1. Add a Span that says “Start” on the left side of the tabs
     * 3.2. Add a Span that says “End” on the right side of the tabs
     * 3.3. Add a border around the component
     * 
     * 4.
     * 4.1. Try switching between tabs by using mouse
     * 4.2. Try switching between tabs and focusing on the content by using the keyboard only
     * 4.3. Try switching between tabs by using a mobile device
     * 
     */
    public TabSheetView() {
    }
}
