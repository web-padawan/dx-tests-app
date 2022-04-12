package com.example.application.views.gridview;

import com.example.application.data.entity.SamplePerson;
import com.example.application.data.service.SamplePersonService;
import com.example.application.views.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Grid View (Java)")
@Route(value = "grid-view-java", layout = MainLayout.class)
public class GridView extends Div {

    private Grid<SamplePerson> grid = new Grid<>(SamplePerson.class, false);

    private SamplePerson samplePerson;

    private final SamplePersonService samplePersonService;

    @Autowired
    public GridView(SamplePersonService samplePersonService) {
        this.samplePersonService = samplePersonService;
        addClassNames("grid-view");

        grid.addColumn("firstName");
        grid.addColumn("lastName");
        grid.addColumn("email");
        grid.addColumn("phone");
        grid.addColumn("dateOfBirth");
        grid.addColumn("occupation");

        grid.setItems(query -> samplePersonService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        add(grid);
    }
}
