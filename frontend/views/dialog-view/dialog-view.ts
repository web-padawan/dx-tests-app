import '@vaadin/button';
import '@vaadin/dialog';
import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../view';

@customElement('dialog-view')
export class DialogView extends View {

  render() {
    /*
     *  1. Add a dialog with some text content, and a button to open it.
     *
     *  2. Configure the dialog to display the title above the content.
     *
     *  3. Add header with a single “close” button to close the dialog.
     *
     *  4. Add a footer with two buttons to the dialog.
     *
     *  5. Make the dialog draggable, and try to drag it.
     */
    return html`
    `;
  }
}
