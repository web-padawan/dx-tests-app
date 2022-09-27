import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { View } from '../view';

@customElement('tabsheet-view')
export class TabSheetView extends View {

    /**
     * Tasks to complete:
     *
     * 1.
     * 1.1. Add a TabSheet to the view
     * 1.2. Add tabs with captions “Analytics”, “Customers”, “Dashboards”, and anything (like lorem ipsum) as the content
     * 1.3. Add a disabled tab with the caption “Orders” and anything as the content
     * 
     * 2.
     * 2.1. (not meaningful in the web component test)
     * 2.2. (not meaningful in the web component test)
     * 2.3. When changing a tab, print the index of the selected tab
     * 
     * 3.
     * 3.1. Add a Span that says “Start” on the left side of the tabs
     * 3.2. Add a Span that says “End” on the right side of the tabs
     * 3.3. Add a border around the component
     * 
     * 4.
     * 4.1. Try switching between tabs by using mouse
     * 4.2. Try switching between tabs and focusing on the content by using the keyboard only
     * 4.3. Try switching between tabs by using a mobile device
     * 
     */
  render() {
    return html`
    `;
  }

  async connectedCallback() {
    super.connectedCallback();
    this.classList.add('flex', 'flex-col', 'h-full');
  }
}
