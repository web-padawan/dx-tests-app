import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../view';

@customElement('tooltip-view')
export class TooltipView extends View {
  render() {
    return html`
    `;
  }

  async connectedCallback() {
    super.connectedCallback();
    this.classList.add('flex', 'flex-col', 'h-full');
  }
}
