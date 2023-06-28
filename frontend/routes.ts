import { Flow } from 'Frontend/generated/jar-resources/Flow.js';
import { Route } from '@vaadin/router';
import './views/main-layout';

const { serverSideRoutes } = new Flow({
  imports: () => import('./generated/flow/generated-flow-imports.js'),
});

export type ViewRoute = Route & {
  title?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  {
    path: 'tabsheet-view-ts',
    component: 'tabsheet-view',
    title: 'TabSheet View (Hilla)',
    action: async (_context, _command) => {
      await import('./views/tabsheet-view/tabsheet-view');
      return;
    },
  },
  {
    path: 'tooltip-view-ts',
    component: 'tooltip-view',
    title: 'Tooltip View (Hilla)',
    action: async (_context, _command) => {
      await import('./views/tooltip-view/tooltip-view');
      return;
    },
  },
];
export const routes: ViewRoute[] = [
  {
    path: '',
    component: 'main-layout',
    children: [
      ...views,
      // for server-side, the next magic line sends all unmatched routes:
      ...serverSideRoutes, // IMPORTANT: this must be the last entry in the array
    ],
  },
];
