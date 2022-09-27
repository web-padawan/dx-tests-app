import { html } from 'lit';
import { customElement, state } from 'lit/decorators.js';
import '@vaadin/button';
import '@vaadin/grid';
import '@vaadin/grid/vaadin-grid-selection-column.js';
import '@vaadin/horizontal-layout';
import '@vaadin/icon';
import '@vaadin/icons';
import '@vaadin/menu-bar';
import '@vaadin/radio-group';
import '@vaadin/split-layout';
import '@vaadin/text-field';
import '@vaadin/vertical-layout';
import { columnBodyRenderer } from '@vaadin/grid/lit.js';
import { GridSelectedItemsChangedEvent } from '@vaadin/grid';
import { GridSelectionColumnSelectAllChangedEvent } from '@vaadin/grid/vaadin-grid-selection-column.js';
import { MenuBarItemSelectedEvent } from '@vaadin/menu-bar';
import { RadioGroupValueChangedEvent } from '@vaadin/radio-group';
import { TextFieldChangeEvent } from '@vaadin/text-field';
import { View } from '../view';

function createIcon(name: string) {
  const component = document.createElement('vaadin-icon');
  component.icon = `vaadin:${name}`;
  component.style.padding = 'var(--lumo-space-xs)';
  return component;
}

type TaskStatus = 'todo' | 'wip' | 'done';

type Task = {
  status: TaskStatus;
  description: string;
};

@customElement('tooltip-view')
export class TooltipView extends View {
  @state()
  private newTask = '';

  @state()
  private newTaskStatus?: TaskStatus;

  @state()
  private tasks: Task[] = [
    { description: 'Add tooltip for the Description field. Content: "Max 100 characters"', status: 'todo' },
    { description: 'Change the tooltip to make it appear on the right', status: 'todo' },
    { description: 'Make sure the tooltip only opens after waiting for 0.5s', status: 'todo' },
    { description: 'Add tooltip for "Create" button. Content: "All fields are required"', status: 'todo' },
    { description: 'Show the tooltip when "Create" button is disabled and hide otherwise', status: 'todo' },
    { description: 'Add tooltip for Grid (status column only). Content: status of the task', status: 'todo' },
    { description: 'Add tooltip for "Actions" (show above). Content: "Select rows first"', status: 'todo' },
    { description: 'Add tooltips for each button in the Menu Bar. Content: button action', status: 'todo' },
    { description: 'Configure all tooltips at once to wait before opening and closing', status: 'todo' },
  ];

  @state()
  private actions = [
    {
      text: 'todo',
      component: createIcon('minus-square-o'),
    },
    {
      text: 'wip',
      component: createIcon('hourglass'),
    },
    {
      text: 'done',
      component: createIcon('check-square-o'),
    },
    {
      text: 'clear',
      component: createIcon('archive'),
    },
  ];

  @state()
  private selectedTasks: Task[] = [];

  render() {
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
    return html`
      <vaadin-vertical-layout theme="padding spacing">
        <vaadin-split-layout>
          <!-- List of tasks -->
          <vaadin-grid
            .items="${this.tasks}"
            .selectedItems="${this.selectedTasks}"
            style="width: 700px"
            all-rows-visible
            @selected-items-changed="${(event: GridSelectedItemsChangedEvent<Task>) =>
              (this.selectedTasks = event.detail.value)}"
          >
            <vaadin-grid-selection-column
              auto-select
              @select-all-changed="${(event: GridSelectionColumnSelectAllChangedEvent) =>
                (this.selectedTasks = event.detail.value ? this.tasks : this.selectedTasks)}"
            ></vaadin-grid-selection-column>
            <vaadin-grid-column path="description" header="Task Description"></vaadin-grid-column>
            <vaadin-grid-column
              path="status"
              flex-grow="0"
              ${columnBodyRenderer((item: any) => {
                let icon = 'minus-square-o';
                switch (item.status) {
                  case 'wip':
                    icon = 'hourglass';
                    break;
                  case 'done':
                    icon = 'check-square-o';
                    break;
                }
                return html`<vaadin-icon icon="vaadin:${icon}"></vaadin-icon>`;
              }, [])}
            ></vaadin-grid-column>
          </vaadin-grid>

          <!-- Create task form -->
          <vaadin-vertical-layout theme="padding spacing">
            <h2 style="margin: 0">New task</h2>

            <vaadin-text-field
              label="Description"
              maxlength="100"
              .value="${this.newTask}"
              @change="${this.onTaskChange}"
            ></vaadin-text-field>

            <vaadin-radio-group label="Status" @value-changed="${this.onStatusChange}">
              <vaadin-radio-button label="Not started" value="todo"></vaadin-radio-button>
              <vaadin-radio-button label="In progress" value="wip"></vaadin-radio-button>
              <vaadin-radio-button label="Completed" value="done"></vaadin-radio-button>
            </vaadin-radio-group>

            <vaadin-button .disabled="${!this.newTask || !this.newTaskStatus}" @click="${this.onCreateClick}">
              Create
            </vaadin-button>
          </vaadin-vertical-layout>
        </vaadin-split-layout>

        <!-- Task actions -->
        <div>
          <b>Actions</b>
          <vaadin-menu-bar
            .disabled="${this.selectedTasks.length === 0}"
            .items="${this.actions}"
            theme="icon"
            @item-selected="${this.onMenuAction}"
          ></vaadin-menu-bar>
        </div>
      </vaadin-vertical-layout>
    `;
  }

  private onCreateClick() {
    if (this.newTask && this.newTaskStatus) {
      this.tasks = [...this.tasks, { description: this.newTask, status: this.newTaskStatus }];
      this.newTask = '';
      this.newTaskStatus = undefined;
    }
  }

  private onMenuAction(event: MenuBarItemSelectedEvent) {
    const item = event.detail.value;

    if (Array.isArray(this.selectedTasks)) {
      const tasks = [...this.tasks];
      const selectedTasks = [...this.selectedTasks];

      this.selectedTasks.forEach((selectedTask) => {
        if (item.text) {
          if (item.text === 'clear') {
            tasks.splice(tasks.indexOf(selectedTask), 1);
            selectedTasks.splice(selectedTasks.indexOf(selectedTask), 1);
          } else {
            const updatedTask = { ...selectedTask, status: item.text as TaskStatus };
            tasks.splice(tasks.indexOf(selectedTask), 1, updatedTask);
            selectedTasks.splice(selectedTasks.indexOf(selectedTask), 1, updatedTask);
          }
        }
      });

      this.tasks = tasks;
      this.selectedTasks = selectedTasks;
    }
  }

  private onTaskChange(event: TextFieldChangeEvent) {
    this.newTask = event.target.value;
  }

  private onStatusChange(event: RadioGroupValueChangedEvent) {
    this.newTaskStatus = event.detail.value as TaskStatus;
  }
}
