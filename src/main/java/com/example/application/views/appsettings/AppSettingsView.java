package com.example.application.views.appsettings;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.Direction;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.Lumo;
import com.vaadin.flow.theme.lumo.LumoIcon;

@PageTitle("App Settings (Flow)")
@Route(value = "app-settings-flow")
public class AppSettingsView extends VerticalLayout {

    public AppSettingsView() {
        // TODO:
        // 1. Change "Settings" form to open in the popup below the button instead of the dialog.
        // 2. Make the other elements on the page greyed out when "Settings" popup is open,
        //   similarly to how it was looking when the dialog was used.
        // 3. Add "Apply" button to the popup, make it close the popup and apply changes on click
        //    (instead of setting theme / direction immediately when selecting them).
        // 4. Add "Cancel" button to the popup, make it close the popup without applying changes.
        // 5. Disallow closing the popup by Esc key and outside click, so that it can be only closed
        //    by pressing the "Apply" or "Cancel" button.
        Dialog dialog = new Dialog();
        dialog.setHeaderTitle("Settings");

        RadioButtonGroup<String> theme = new RadioButtonGroup<>("Theme");
        theme.setItems("Light", "Dark");
        theme.setValue("Light");
        theme.addValueChangeListener(e -> {
            if (e.getValue().equals("Dark")) {
                UI.getCurrent().getElement().getThemeList().add(Lumo.DARK);
            } else {
                UI.getCurrent().getElement().getThemeList().remove(Lumo.DARK);
            }
        });

        RadioButtonGroup<String> direction = new RadioButtonGroup<>("Direction");
        direction.setItems("LTR", "RTL");
        direction.setValue("LTR");
        direction.addValueChangeListener(e -> {
            if (e.getValue().equals("RTL")) {
                UI.getCurrent().setDirection(Direction.RIGHT_TO_LEFT);
            } else {
                UI.getCurrent().setDirection(Direction.LEFT_TO_RIGHT);
            }
        });

        VerticalLayout layout = new VerticalLayout(theme, direction);
        layout.setSpacing(false);
        layout.setPadding(false);
        dialog.add(layout);

        Button button = new Button(LumoIcon.COG.create());
        button.addThemeVariants(ButtonVariant.LUMO_ICON);
        button.addClickListener(e -> {
            dialog.open();
        });

        add(button);
    }
}
