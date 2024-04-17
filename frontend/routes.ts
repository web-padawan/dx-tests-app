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
    path: 'grid-pro-view-hilla',
    component: 'grid-pro-view',
    title: 'GridPro View (Hilla)',
    action: async (_context, _command) => {
      await import('./views/grid-pro-view/grid-pro-view');
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
