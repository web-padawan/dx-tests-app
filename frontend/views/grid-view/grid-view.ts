import '@vaadin/grid';
import { Grid, GridDataProviderCallback, GridDataProviderParams } from '@vaadin/grid';
import '@vaadin/grid/vaadin-grid-sort-column';
import Sort from 'Frontend/generated/dev/hilla/mappedtypes/Sort';
import Person from 'Frontend/generated/com/example/application/data/entity/Person';
import Direction from 'Frontend/generated/org/springframework/data/domain/Sort/Direction';
import * as PersonEndpoint from 'Frontend/generated/PersonEndpoint';
import { html } from 'lit';
import { customElement, property, query } from 'lit/decorators.js';
import { View } from '../view';

@customElement('grid-view')
export class GridView extends View {
  @query('#grid')
  private grid!: Grid;

  @property({ type: Number })
  private gridSize = 0;

  private gridDataProvider = this.getGridData.bind(this);

  render() {
    /*
     *  1. Set max width on the grid to make it scroll horizontally.
     *
     *  2. Make the "first name" column frozen.
     *
     *  3. Make the "occupation" column frozen.
     *
     *  4. Make both frozen columns resizable and try to resize them.
     */
    return html`
      <vaadin-grid
        id="grid"
        class="w-full h-full"
        theme="no-border"
        .size=${this.gridSize}
        .dataProvider=${this.gridDataProvider}
      >
        <vaadin-grid-sort-column path="firstName"></vaadin-grid-sort-column>
        <vaadin-grid-sort-column path="lastName"></vaadin-grid-sort-column>
        <vaadin-grid-sort-column path="email"></vaadin-grid-sort-column>
        <vaadin-grid-sort-column path="phone"></vaadin-grid-sort-column>
        <vaadin-grid-sort-column path="dateOfBirth"></vaadin-grid-sort-column>
        <vaadin-grid-sort-column path="occupation"></vaadin-grid-sort-column>
      </vaadin-grid>
    `;
  }

  private async getGridData(
    params: GridDataProviderParams<Person>,
    callback: GridDataProviderCallback<Person | undefined>
  ) {
    const sort: Sort = {
      orders: params.sortOrders.map((order) => ({
        property: order.path,
        direction: order.direction == 'asc' ? Direction.ASC : Direction.DESC,
        ignoreCase: false,
      })),
    };
    const data = await PersonEndpoint.list({ pageNumber: params.page, pageSize: params.pageSize, sort });
    callback(data);
  }

  async connectedCallback() {
    super.connectedCallback();
    this.classList.add('flex', 'flex-col', 'h-full');
    this.gridSize = (await PersonEndpoint.count()) ?? 0;
  }
}
