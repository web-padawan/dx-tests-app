package com.example.application.views.gridproview;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.gridpro.GridPro;
import com.vaadin.flow.component.gridpro.GridProVariant;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Grid Pro View")
@Route(value = "grid-pro-view")
public class GridProView extends VerticalLayout {
    /**
     * Configure GridPro as follows:
     *
     * 1. Only allow editing hours when the task status is "in progress"
     * 2. Disallow changing task status and hours when the task is archived
     * 3. Only allow changing archived if the status is "done" or "canceled"
     */
    public GridProView() {
        GridPro<Task> grid = new GridPro<>();

        grid.addEditColumn(Task::getName).text(Task::setName).setHeader("Name");

        List<String> statusOptions = Arrays.asList("todo", "in progress",
                "done", "canceled");
        grid.addEditColumn(Task::getStatus)
                .select(Task::setStatus, statusOptions).setHeader("Status");

        IntegerField hoursField = new IntegerField();
        hoursField.setWidthFull();

        grid.addEditColumn(Task::getHours).custom(hoursField, Task::setHours)
                .setHeader("Hours spent");

        grid.addEditColumn(Task::getArchived).checkbox(Task::setArchived)
                .setHeader("Archived");

        grid.setAllRowsVisible(true);
        grid.setItems(tasks);
        grid.addThemeVariants(GridProVariant.LUMO_HIGHLIGHT_READ_ONLY_CELLS);
        add(grid);
    }

    private List<Task> tasks = new ArrayList<Task>(
            Arrays.asList(new Task("Build a prototype", "done", 8, true),
                    new Task("Conduct the research", "canceled", 0, true),
                    new Task("Create the design", "in progress", 10, false),
                    new Task("Implement the UI", "todo", 0, false),
                    new Task("Add integration tests", "todo", 0, false),
                    new Task("Deploy to production", "todo", 0, false)));

    public static class Task {
        private String name;
        private String status;
        private int hours;
        private boolean archived;

        public Task(String name, String status, int hours, boolean archived) {
            this.name = name;
            this.status = status;
            this.hours = hours;
            this.archived = archived;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        public boolean getArchived() {
            return archived;
        }

        public void setArchived(boolean archived) {
            this.archived = archived;
        }
    }
}
