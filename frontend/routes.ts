import { Flow } from '@vaadin/flow-frontend';
import { Route } from '@vaadin/router';
import './views/main-layout';

const { serverSideRoutes } = new Flow({
  imports: () => import('../target/frontend/generated-flow-imports'),
});

export type ViewRoute = Route & {
  title?: string;
  children?: ViewRoute[];
};

export const views: ViewRoute[] = [
  {
    path: 'grid-view-ts',
    component: 'grid-view',
    title: 'Grid View (TS)',
    action: async (_context, _command) => {
      await import('./views/grid-view/grid-view');
      return;
    },
  },
  {
    path: 'dialog-view-ts',
    component: 'dialog-view',
    title: 'Dialog View (TS)',
    action: async (_context, _command) => {
      await import('./views/dialog-view/dialog-view');
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
