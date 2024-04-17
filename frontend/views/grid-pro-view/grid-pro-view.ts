import { html } from 'lit';
import { customElement, state } from 'lit/decorators.js';
import { View } from '../view';
import '@vaadin/grid-pro';
import '@vaadin/grid-pro/vaadin-grid-pro-edit-column.js';
import '@vaadin/vertical-layout';

@customElement('grid-pro-view')
export class GridProView extends View {
  @state()
  statuses = ['todo', 'in progress', 'done', 'canceled'];

  @state()
  tasks = [
    { name: 'Build a prototype', hours: 8, status: 'done', archived: true},
    { name: 'Conduct the research', hours: 0, status: 'canceled', archived: true},
    { name: 'Create the design', hours: 10, status: 'in progress', archived: false},
    { name: 'Implement the UI', hours: 0, status: 'todo', archived: false},
    { name: 'Add integration tests', hours: 0, status: 'todo', archived: false},
    { name: 'Deploy to production', hours: 0, status: 'todo', archived: false},
  ];

  /**
   * Configure GridPro as follows:
   *
   * 1. Only allow editing hours when the task status is "in progress"
   * 2. Disallow changing task status and hours when the task is archived
   * 3. Only allow changing archived if the status is "done" or "canceled"
   */
  render() {
    return html`
      <vaadin-vertical-layout theme="padding">
        <vaadin-grid-pro .items="${this.tasks}" all-rows-visible>
          <vaadin-grid-pro-edit-column path="name"></vaadin-grid-pro-edit-column>
           <vaadin-grid-pro-edit-column
            path="status"
            editor-type="select"
            .editorOptions="${this.statuses}"
          ></vaadin-grid-pro-edit-column>
          <vaadin-grid-pro-edit-column path="hours" header="Hours spent"></vaadin-grid-pro-edit-column>
          <vaadin-grid-pro-edit-column path="archived" editor-type="checkbox"></vaadin-grid-pro-edit-column>
        </vaadin-grid-pro>
      </vaadin-vertical-layout>
    `;
  }
}
