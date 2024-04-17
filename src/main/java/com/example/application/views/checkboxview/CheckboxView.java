package com.example.application.views.checkboxview;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.converter.StringToBooleanConverter;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@PageTitle("Checkbox View")
@Route(value = "checkbox-view")
@RouteAlias(value = "")
public class CheckboxView extends VerticalLayout {
    /**
     * Refactor the form as follows:
     *
     * 1. Replace MultiSelectComboBox with the CheckboxGroup
     *   - Make sure every checkbox in a group has helper text
     *     that would show the corresponding description field
     *
     * 2. Replace RadioButtonGroup with the Checkbox
     *   - Make sure the checkbox can be validated using the Binder
     *
     * 3. Add a "Save" button with a click listener to the form
     *   - Make all the fields non-editable when button is clicked
     *   - Try to interact with the Checkbox and the CheckboxGroup
     */
    public CheckboxView() {
        // Passenger name
        TextField name = new TextField("Passenger name");
        name.setWidth("300px");

        // Additional services
        MultiSelectComboBox<Service> services = new MultiSelectComboBox<>();
        services.setWidth("300px");
        services.setLabel("Additional services");
        services.setItems(servicesList);
        services.setItemLabelGenerator(item -> item.getName());
        services.setRenderer(LitRenderer.<Service> of(
                "<div>${item.name}</div><div><i>${item.description}</i></div>")
                .withProperty("name", item -> item.getName())
                .withProperty("description", item -> item.getDescription()));

        // Confirmed
        RadioButtonGroup<String> confirmed = new RadioButtonGroup<>(
                "Confirmed");
        confirmed.setItems("yes", "no");

        add(name, services, confirmed);

        Binder<Reservation> binder = new Binder<>(Reservation.class);

        binder.forField(name).asRequired("Name is required")
                .bind(Reservation::getName, Reservation::setName);

        binder.forField(services).bind(Reservation::getServices,
                Reservation::setServices);

        binder.forField(confirmed)
                .withConverter(new StringToBooleanConverter("Not a boolean",
                        "yes", "no"))
                .withValidator(value -> Boolean.TRUE.equals(value),
                        "Must be confirmed")
                .bind(Reservation::getApproved, Reservation::setApproved);
    }

    private List<Service> servicesList = Arrays.asList(
            new Service("Seat", "Select your seat now"),
            new Service("Meal", "Pick a menu of choice"),
            new Service("Baggage", "Extra baggage up to 22kg"));

    public static class Service {
        private String name;
        private String description;

        public Service(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public static class Reservation {
        private String name;
        private Boolean approved;
        private Set<Service> services;

        public Reservation(String name, boolean approved,
                Set<Service> services) {
            this.name = name;
            this.approved = approved;
            this.services = services;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Boolean getApproved() {
            return approved;
        }

        public void setApproved(Boolean approved) {
            this.approved = approved;
        }

        public Set<Service> getServices() {
            return services;
        }

        public void setServices(Set<Service> services) {
            this.services = services;
        }
    }
}
