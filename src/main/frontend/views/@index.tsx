import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { NavLink } from 'react-router';
import { VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = { title: 'Home' };

export default function HomeView() {
  return (
    <VerticalLayout theme="padding spacing">
      <ul>
        <li>
          <NavLink to="/flow">Flow view</NavLink>
        </li>
        <li>
          <NavLink to="/react">React view</NavLink>
        </li>
      </ul>
    </VerticalLayout>
  );
}
