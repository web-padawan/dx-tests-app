package com.example.application.views.tooltipview;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.menubar.MenuBarVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Tooltip View")
@Route(value = "tooltip-view")
public class TooltipView extends VerticalLayout {

    private String newTaskDescription;

    private TaskStatus newTaskStatus;

    private Set<Task> selectedTasks = new LinkedHashSet<>();

    private Grid<Task> grid = new Grid<>(Task.class, false);

    /**
     * Tasks to complete:
     *
     * Task 1.
     * - Add tooltip for the Description field. Content: "Max 100 characters"
     * - Change the tooltip to make it appear on the right
     * - Make sure the tooltip only opens after waiting for 0.5s
     *
     * Task 2.
     * - Add tooltip for "Create" button. Content: "All fields are required"
     * - Show the tooltip when "Create" button is disabled and hide otherwise
     *
     * Task 3.
     * - Add tooltip for Grid (status column only). Content: status of the task
     *
     * Task 4.
     * - Add tooltip for "Actions" (show above). Content: "Select rows first"
     *
     * Task 5.
     * - Add tooltips for each button in the Menu Bar. Content: button action
     *
     * Task 6.
     * - Configure all tooltips at once to wait before opening and closing
     */
    public TooltipView() {
        SplitLayout splitLayout = new SplitLayout();

        // List of tasks
        grid.setWidth("700px");
        grid.setSelectionMode(Grid.SelectionMode.MULTI);
        grid.setAllRowsVisible(true);
        grid.addColumn(Task::getDescription).setHeader("Task Description");
        grid.addComponentColumn(task -> createStatusIcon(task.getStatus()))
                .setHeader("Status").setFlexGrow(0);
        ListDataProvider<Task> dataProvider = new ListDataProvider<>(tasks);
        grid.setDataProvider(dataProvider);

        // Create task form
        VerticalLayout createTaskLayout = new VerticalLayout();

        H2 newTaskTitle = new H2("New task");
        newTaskTitle.getStyle().set("margin", "0");

        TextField descriptionField = new TextField("Description");

        RadioButtonGroup<TaskStatus> statusGroup = new RadioButtonGroup<>(
                "Status");
        statusGroup.setItems(statuses);

        Button createButton = new Button("Create");
        createButton.setEnabled(false);

        createButton.addClickListener(event -> {
            addTask();
            descriptionField.setValue("");
            statusGroup.setValue(null);
        });

        descriptionField.addValueChangeListener(event -> {
            String value = event.getValue();
            newTaskDescription = value.equals("") ? null : value;
            createButton.setEnabled(
                    newTaskStatus != null && newTaskDescription != null);
        });

        statusGroup.addValueChangeListener(event -> {
            newTaskStatus = event.getValue();
            createButton.setEnabled(
                    newTaskStatus != null && newTaskDescription != null);
        });

        createTaskLayout.getStyle().set("width", "auto");
        createTaskLayout.add(newTaskTitle, descriptionField, statusGroup,
                createButton);

        splitLayout.addToPrimary(grid);
        splitLayout.addToSecondary(createTaskLayout);
        add(splitLayout);

        // Task actions
        Div div = new Div();
        Html actionsCaption = new Html("<b>Actions</b>");

        MenuBar menuBar = new MenuBar();
        menuBar.addThemeVariants(MenuBarVariant.LUMO_ICON);

        menuBar.addItem(new Icon(VaadinIcon.MINUS_SQUARE_O),
                event -> updateSelectedTasks(statuses.get(0)));
        menuBar.addItem(new Icon(VaadinIcon.HOURGLASS),
                event -> updateSelectedTasks(statuses.get(1)));
        menuBar.addItem(new Icon(VaadinIcon.CHECK_SQUARE_O),
                event -> updateSelectedTasks(statuses.get(2)));
        menuBar.addItem(new Icon(VaadinIcon.ARCHIVE),
                event -> removeSelectedTasks());

        menuBar.setEnabled(false);
        grid.addSelectionListener(selection -> {
            Set<Task> selected = selection.getAllSelectedItems();
            selectedTasks = selected.size() == 0 ? null : selected;
            menuBar.setEnabled(selectedTasks != null);
        });

        div.add(actionsCaption, menuBar);
        add(div);
    }

    private List<TaskStatus> statuses = Arrays.asList(
            new TaskStatus("Not started", "todo"),
            new TaskStatus("In progress", "wip"),
            new TaskStatus("Completed", "done"));

    private List<Task> tasks = new ArrayList<Task>(Arrays.asList(new Task(
            "Add tooltip for the Description field. Content: \"Max 100 characters\"",
            statuses.get(0)),
            new Task("Change the tooltip to make it appear on the right",
                    statuses.get(0)),
            new Task("Make sure the tooltip only opens after waiting for 0.5s",
                    statuses.get(0)),
            new Task(
                    "Add tooltip for \"Create\" button. Content: \"All fields are required\"",
                    statuses.get(0)),
            new Task(
                    "Show the tooltip when \"Create\" button is disabled and hide otherwise",
                    statuses.get(0)),
            new Task(
                    "Add tooltip for Grid (status column only). Content: status of the task",
                    statuses.get(0)),
            new Task(
                    "Add tooltip for \"Actions\" (show above). Content: \"Select rows first\"",
                    statuses.get(0)),
            new Task(
                    "Add tooltips for each button in the Menu Bar. Content: button action",
                    statuses.get(0)),
            new Task(
                    "Configure all tooltips at once to wait before opening and closing",
                    statuses.get(0))));

    private void addTask() {
        Task task = new Task(newTaskDescription, newTaskStatus);
        tasks.add(task);
        grid.getDataProvider().refreshAll();
    }

    private void removeSelectedTasks() {
        if (selectedTasks != null) {
            selectedTasks.forEach(task -> {
                tasks.remove(task);
                grid.deselect(task);
            });

            grid.getDataProvider().refreshAll();
        }
    }

    private void updateSelectedTasks(TaskStatus status) {
        if (selectedTasks != null) {
            selectedTasks.forEach(task -> {
                task.setStatus(status);
            });

            grid.getDataProvider().refreshAll();
        }
    }

    private Icon createStatusIcon(TaskStatus status) {
        String value = status.getValue();
        Icon icon;
        switch (value) {
        case "wip":
            return VaadinIcon.HOURGLASS.create();
        case "done":
            return VaadinIcon.CHECK_SQUARE_O.create();
        default:
            return VaadinIcon.MINUS_SQUARE_O.create();
        }
    }

    private static class TaskStatus {
        private final String label;
        private final String value;

        public TaskStatus(String label, String value) {
            this.label = label;
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public static class Task {

        private String description;
        private TaskStatus status;

        public Task(String description, TaskStatus status) {
            this.description = description;
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public TaskStatus getStatus() {
            return status;
        }

        public void setStatus(TaskStatus status) {
            this.status = status;
        }
    }
}
