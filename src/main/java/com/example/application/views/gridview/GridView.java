package com.example.application.views.gridview;

import com.example.application.data.entity.Person;
import com.example.application.data.service.PersonService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.data.VaadinSpringDataHelpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;

@PageTitle("Grid View (Java)")
@Route(value = "grid-view-java")
public class GridView extends Div {

    private Grid<Person> grid = new Grid<>(Person.class, false);

    private final PersonService personService;

    @Autowired
    public GridView(PersonService personService) {
        this.personService = personService;
        addClassNames("grid-view");

        grid.addColumn("firstName");
        grid.addColumn("lastName");
        grid.addColumn("email");
        grid.addColumn("phone");
        grid.addColumn("dateOfBirth");
        grid.addColumn("occupation");

        grid.setItems(query -> personService.list(
                PageRequest.of(query.getPage(), query.getPageSize(), VaadinSpringDataHelpers.toSpringDataSort(query)))
                .stream());
        grid.addThemeVariants(GridVariant.LUMO_NO_BORDER);

        add(grid);

        /*
         *  1. Set max width on the grid to make it scroll horizontally.
         *
         *  2. Make the "first name" column frozen.
         *
         *  3. Make the "occupation" column frozen.
         *
         *  4. Make both frozen columns resizable and try to resize them.
         */
    }
}
