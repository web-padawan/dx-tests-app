import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../view';

@customElement('tabsheet-view')
export class TabSheetView extends View {
  render() {
    return html`
    `;
  }

  async connectedCallback() {
    super.connectedCallback();
    this.classList.add('flex', 'flex-col', 'h-full');
  }
}
