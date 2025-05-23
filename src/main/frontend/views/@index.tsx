import { ViewConfig } from '@vaadin/hilla-file-router/types.js';
import { NavLink } from 'react-router';
import { VerticalLayout } from '@vaadin/react-components';

export const config: ViewConfig = { title: 'Home' };

export default function HomeView() {
  return (
    <VerticalLayout theme="padding spacing">
      <ul>
        <li>
          <NavLink to="/app-settings-flow">App Settings (Flow)</NavLink>
        </li>
        <li>
          <NavLink to="/app-settings-react">App Settings (React)</NavLink>
        </li>
        <li>
          <NavLink to="/cvv-field-flow">CVV Field (Flow)</NavLink>
        </li>
        <li>
          <NavLink to="/cvv-field-react">CVV Field (React)</NavLink>
        </li>
      </ul>
    </VerticalLayout>
  );
}
