import '@vaadin/app-layout';
import '@vaadin/app-layout/vaadin-drawer-toggle';
import { AppLayout } from '@vaadin/app-layout';
import { html } from 'lit';
import { customElement } from 'lit/decorators.js';
import { router } from '../index';
import { appStore } from '../stores/app-store';
import { Layout } from './view';

interface RouteInfo {
  path: string;
  title: string;
}

@customElement('main-layout')
export class MainLayout extends Layout {
  render() {
    return html`
      <vaadin-app-layout primary-section="drawer">
        <header class="bg-base border-b border-contrast-10 box-border flex h-xl items-center w-full" slot="navbar">
          <vaadin-drawer-toggle aria-label="Menu toggle" class="text-secondary" theme="contrast"></vaadin-drawer-toggle>
          <h1 class="m-0 text-l">${appStore.currentViewTitle}</h1>
        </header>
        <section class="flex flex-col items-stretch max-h-full min-h-full" slot="drawer">
          <h2 class="flex items-center h-xl m-0 px-m text-m">${appStore.applicationName}</h2>
          <nav class="border-b border-contrast-10 flex-grow overflow-auto">
            <ul class="list-none m-0 p-0">
              ${this.getMenuRoutes().map(
                (viewRoute) => html`
                  <li>
                    <a
                      ?highlight=${viewRoute.path == appStore.location}
                      class="flex mx-s p-s relative text-secondary"
                      href=${router.urlForPath(viewRoute.path)}
                    >
                      <span class="font-medium text-s">${viewRoute.title}</span>
                    </a>
                  </li>
                `
              )}
            </ul>
          </nav>
          <footer class="flex items-center my-s px-m py-xs"></footer>
        </section>
        <slot></slot>
      </vaadin-app-layout>
    `;
  }

  connectedCallback() {
    super.connectedCallback();
    this.classList.add('block', 'h-full');
    this.reaction(
      () => appStore.location,
      () => {
        AppLayout.dispatchCloseOverlayDrawerEvent();
      }
    );
  }

  private getMenuRoutes(): RouteInfo[] {
    return [
      {
        path: 'grid-pro-view',
        title: 'GridPro View (Flow)'
      },
      {
        path: 'grid-pro-view-hilla',
        title: 'GridPro View (Hilla)'
      },
    ];
  }
}
